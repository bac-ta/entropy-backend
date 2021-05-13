package com.entropy.backend.service;

import com.entropy.backend.model.rest.request.auth.LoginInfoRequest;
import com.entropy.backend.model.rest.response.auth.LoginInfoResponse;
import com.entropy.backend.security.jwt.AccountPrincipal;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    LoginInfoResponse login(LoginInfoRequest req);
    AccountPrincipal getCurrentPrincipal();
}
