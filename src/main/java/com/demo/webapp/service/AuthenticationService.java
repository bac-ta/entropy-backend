package com.demo.webapp.service;

import com.demo.webapp.constant.APIMessage;
import com.demo.webapp.factory.JwtTokenProviderFactory;
import com.demo.webapp.rest.request.LoginInfoReq;
import com.demo.webapp.rest.response.LoginInfoResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private JwtTokenProviderFactory jwtFactory;
    private AuthenticationManager authManager;

    @Autowired
    public AuthenticationService(JwtTokenProviderFactory jwtFactory, AuthenticationManager authManager) {
        this.jwtFactory = jwtFactory;
        this.authManager = authManager;
    }

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

}
