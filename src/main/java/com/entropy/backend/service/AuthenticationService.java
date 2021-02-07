package com.entropy.backend.service;

import com.entropy.backend.model.rest.request.auth.LoginInfoReq;
import com.entropy.backend.model.rest.response.auth.LoginInfoResp;
import com.entropy.backend.security.jwt.AccountPrincipal;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    LoginInfoResp login(LoginInfoReq req);
    AccountPrincipal getCurrentPrincipal();
}
