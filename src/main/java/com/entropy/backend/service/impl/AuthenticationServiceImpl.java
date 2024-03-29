package com.entropy.backend.service.impl;

import com.entropy.backend.common.constant.APIMessage;
import com.entropy.backend.model.rest.request.auth.LoginInfoReq;
import com.entropy.backend.model.rest.response.auth.LoginInfoResp;
import com.entropy.backend.pattern.factory.JwtTokenProviderFactory;
import com.entropy.backend.security.jwt.AccountPrincipal;
import com.entropy.backend.service.AuthenticationService;
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
    public LoginInfoResp login(LoginInfoReq req) {
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
        return new LoginInfoResp(APIMessage.LOGIN_SUCCESSFUL, jwt);
    }

    @Override
    public AccountPrincipal getCurrentPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (AccountPrincipal) authentication.getPrincipal();
    }


}
