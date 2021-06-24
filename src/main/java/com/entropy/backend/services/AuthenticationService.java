package com.entropy.backend.services;

import com.entropy.backend.configurations.securities.jwts.AccountPrincipal;
import com.entropy.backend.models.rests.requests.authentications.LoginInfoRequest;
import com.entropy.backend.models.rests.responses.authentications.LoginInfoResponse;
import org.springframework.stereotype.Service;

/**
 * Interface provide methods handle authentications
 *
 * @author bac-ta
 * @see AuthenticationService
 * @since 2021-06-10
 */
@Service
public interface AuthenticationService {
    LoginInfoResponse login(LoginInfoRequest req);

    AccountPrincipal getCurrentPrincipal();

    LoginInfoResponse refreshToken(String token);
}
