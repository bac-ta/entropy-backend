package com.entropy.backend.security.oauth2;

import com.entropy.backend.common.constant.APIMessage;
import com.entropy.backend.repository.HttpCookieOAuth2AuthorizationRequestRepository;
import com.entropy.backend.security.jwt.JwtTokenProviderImpl;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import com.entropy.backend.common.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Value("${app.oauth2.redirect-uri-param-cookie-name}")
    private String redirectUriParamCookieName;
    @Value("${app.oauth2.authorized-redirect-uris}")
    private List<String> authorizedRedirectUris;

    private JwtTokenProviderImpl tokenProvider;
    private HttpCookieOAuth2AuthorizationRequestRepository repository;

    @Autowired
    public OAuth2AuthenticationSuccessHandler(JwtTokenProviderImpl tokenProvider, HttpCookieOAuth2AuthorizationRequestRepository repository) {
        this.tokenProvider = tokenProvider;
        this.repository = repository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(request, authentication);
        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }
        clearAuthenticationAttributes(request, response);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(HttpServletRequest request, Authentication authentication) {
        Optional<String> redirectUri = AppUtil.getCookie(request, redirectUriParamCookieName).map(Cookie::getValue);
        if (redirectUri.isPresent() && !isAuthorizedRedirectUri(redirectUri.get())) {
            throw new ResourceNotFoundExceptionHandler(APIMessage.OAUTH2_UNAUTHORIZED);
        }
        String targetUrl = redirectUri.orElse(getDefaultTargetUrl());
        String token = tokenProvider.generateToken(authentication);
        return UriComponentsBuilder.fromUriString(targetUrl).queryParam(
                "token", token
        ).build().toUriString();
    }

    private boolean isAuthorizedRedirectUri(String uri) {
        URI clientRedirectUri = URI.create(uri);
        return authorizedRedirectUris.stream().anyMatch(authUri -> {
            URI authorizedUri = URI.create(authUri);
            return authorizedUri.getHost().equalsIgnoreCase(clientRedirectUri.getHost()) && authorizedUri.getPort() == clientRedirectUri.getPort();
        });
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {
        super.clearAuthenticationAttributes(request);
        repository.removeAuthorizationRequestCookies(request, response);
    }
}
