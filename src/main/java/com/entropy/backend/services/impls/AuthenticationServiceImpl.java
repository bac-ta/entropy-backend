package com.entropy.backend.services.impls;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.models.rests.requests.authentications.LoginInfoRequest;
import com.entropy.backend.models.rests.responses.authentications.LoginInfoResponse;
import com.entropy.backend.patterns.factories.JwtTokenProviderFactory;
import com.entropy.backend.configurations.securities.jwts.AccountPrincipal;
import com.entropy.backend.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author bac-ta
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtTokenProviderFactory jwtFactory;
    private final AuthenticationManager authManager;

    @Autowired
    public AuthenticationServiceImpl(@Qualifier("jwtTokenProviderImpl") JwtTokenProviderFactory jwtFactory, AuthenticationManager authManager) {
        this.jwtFactory = jwtFactory;
        this.authManager = authManager;
    }

    @Override
    public LoginInfoResponse login(LoginInfoRequest req) {
        String emailOrUsername = req.getEmailOrUsername();
        String password = req.getPassword();

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        emailOrUsername,
                        password
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtFactory.generateToken(authentication);
        return new LoginInfoResponse(APIMessage.LOGIN_SUCCESSFUL, jwt);
    }

    @Override
    public AccountPrincipal getCurrentPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (AccountPrincipal) authentication.getPrincipal();
    }


}
