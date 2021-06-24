package com.entropy.backend.services.impls;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.configurations.securities.jwts.AccountPrincipal;
import com.entropy.backend.models.dtos.SessionDto;
import com.entropy.backend.models.entities.RefreshToken;
import com.entropy.backend.models.enumerations.SessionStatusType;
import com.entropy.backend.models.rests.requests.authentications.LoginInfoRequest;
import com.entropy.backend.models.rests.responses.authentications.LoginInfoResponse;
import com.entropy.backend.models.rests.responses.authentications.SessionResponse;
import com.entropy.backend.patterns.factories.JwtTokenProviderFactory;
import com.entropy.backend.services.AuthenticationService;
import com.entropy.backend.services.RefreshTokenService;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class implement {@link AuthenticationService}
 *
 * @author bac-ta
 * @see AuthenticationServiceImpl
 * @since 2021-06-10
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtTokenProviderFactory jwtFactory;
    private final AuthenticationManager authManager;
    private final RefreshTokenService refreshTokenService;

    @Value("${openfire.host}")
    private String openfireHost;
    @Value("${openfire.rest-secret-key}")
    private String openfireRestSecretKey;
    @Value("${openfire.xmpp-client-connection-port}")
    private Integer xmppClientConnectionPort;
    @Value("${openfire.xmpp-domain}")
    private String xmppDomain;
    @Value("${openfire.xmpp-client-bin-port}")
    private String xmppClientBinPort;

    @Autowired
    public AuthenticationServiceImpl(@Qualifier("jwtTokenProviderImpl") JwtTokenProviderFactory jwtFactory, AuthenticationManager authManager, RefreshTokenService refreshTokenService) {
        this.jwtFactory = jwtFactory;
        this.authManager = authManager;
        this.refreshTokenService = refreshTokenService;
    }

    @Override
    public LoginInfoResponse login(LoginInfoRequest req) {
        String username = req.getUsername();
        String password = req.getPassword();

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = jwtFactory.generateToken(authentication);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(username);

        // Login to openfire
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", openfireRestSecretKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);

        final String sessionURI = openfireRestSecretKey + ":" + xmppClientBinPort + "/plugins/restapi/v1/sessions/{username}";

        Map<String, String> uriParam = new HashMap<>();
        uriParam.put("username", username);

        ResponseEntity<SessionResponse> responses = template.exchange(sessionURI, HttpMethod.GET, httpEntity,
                SessionResponse.class, uriParam);

        SessionResponse sessionsResponse = responses.getBody();
        List<SessionDto> dtoList = Objects.requireNonNull(sessionsResponse).getSessions();


        if (dtoList.size() > 0) {
            for (SessionDto sessionDTO : dtoList) {
                if (sessionDTO.getSessionStatus().equals(SessionStatusType.AUTHENTICATED.name()))
                    return new LoginInfoResponse(APIMessage.LOGIN_SUCCESSFUL, accessToken, HttpStatus.OK.value(), refreshToken.getToken());
            }
        }
        //If sessions not exist, we login
        try {
            XMPPTCPConnectionConfiguration config = XMPPTCPConnectionConfiguration.builder()
                    .setUsernameAndPassword(username, password)
                    .setXmppDomain(xmppDomain)
                    .setHost(openfireHost)
                    .setPort(xmppClientConnectionPort)
                    .setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)
                    .build();

            AbstractXMPPConnection conn2 = new XMPPTCPConnection(config);
            conn2.connect().login();
        } catch (InterruptedException | XMPPException | SmackException | IOException e) {
            throw new AuthenticationCredentialsNotFoundException("");
        }


        return new LoginInfoResponse(APIMessage.LOGIN_SUCCESSFUL, accessToken, HttpStatus.OK.value(), refreshToken.getToken());
    }

    @Override
    public AccountPrincipal getCurrentPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (AccountPrincipal) authentication.getPrincipal();
    }

    @Override
    public LoginInfoResponse refreshToken(String token) {
        return refreshTokenService.findByToken(token).map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUsername)
                .map(username->{
                    String jwtToken = jwtFactory

                })
    }

}
