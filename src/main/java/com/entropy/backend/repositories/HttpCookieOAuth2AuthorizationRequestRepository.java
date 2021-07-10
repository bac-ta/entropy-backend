package com.entropy.backend.repositories;

import com.entropy.backend.common.utils.AppUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Repository
public class HttpCookieOAuth2AuthorizationRequestRepository implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {

    @Value("${app.oauth2.auth-request-cookie-name}")
    private String authRequestCookieName;
    @Value("${app.oauth2.redirect-uri-param-cookie-name}")
    private String redirectUriParamCookieName;
    @Value("${app.oauth2.cookie-expire-seconds}")
    private int cookieExpireSeconds;

    @Override
    public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest httpServletRequest) {
        return AppUtil.Cookie.getCookie(httpServletRequest, authRequestCookieName).
                map(cookie -> AppUtil.System.deserialize(cookie, OAuth2AuthorizationRequest.class)).orElse(null);
    }

    @Override
    public void saveAuthorizationRequest(OAuth2AuthorizationRequest oAuth2AuthorizationRequest, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if (oAuth2AuthorizationRequest == null) {
            AppUtil.Cookie.deleteCookie(httpServletRequest, httpServletResponse, authRequestCookieName);
            AppUtil.Cookie.deleteCookie(httpServletRequest, httpServletResponse, redirectUriParamCookieName);
            return;
        }
        AppUtil.Cookie.addCookie(httpServletResponse, authRequestCookieName, AppUtil.System.serialize(oAuth2AuthorizationRequest), cookieExpireSeconds);
        String redirectUriAfterLogin = httpServletRequest.getParameter(redirectUriParamCookieName);
        if (StringUtils.isBlank(redirectUriAfterLogin))
            return;
        AppUtil.Cookie.addCookie(httpServletResponse, redirectUriParamCookieName, redirectUriAfterLogin, cookieExpireSeconds);
    }

    @Override
    public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest httpServletRequest) {
        return null;
    }

    public void removeAuthorizationRequestCookies(HttpServletRequest request, HttpServletResponse response) {
        AppUtil.Cookie.deleteCookie(request, response, authRequestCookieName);
        AppUtil.Cookie.deleteCookie(request, response, authRequestCookieName);
    }
}