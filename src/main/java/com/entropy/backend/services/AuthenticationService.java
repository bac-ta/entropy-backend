package com.entropy.backend.services;

import com.entropy.backend.models.rests.requests.authentications.LoginInfoRequest;
import com.entropy.backend.models.rests.responses.authentications.LoginInfoResponse;
import com.entropy.backend.configurations.securities.jwts.AccountPrincipal;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    LoginInfoResponse login(LoginInfoRequest req);
    AccountPrincipal getCurrentPrincipal();
}
