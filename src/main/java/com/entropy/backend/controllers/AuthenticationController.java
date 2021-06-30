package com.entropy.backend.controllers;

import com.entropy.backend.common.constants.APIEndpointBase;
import com.entropy.backend.models.rests.requests.authentications.LoginInfoRequest;
import com.entropy.backend.models.rests.responses.authentications.LoginInfoResponse;
import com.entropy.backend.models.rests.responses.authentications.TokenRefreshResponse;
import com.entropy.backend.services.AuthenticationService;
import com.entropy.backend.services.RefreshTokenService;
import com.entropy.backend.services.impls.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class controller for creates authentication APIs
 *
 * @author bac-ta
 * @see AuthenticationController
 * @since 2021-05-31
 */
@RestController
@RequestMapping(APIEndpointBase.AUTH_ENDPOINT_BASE)
public class AuthenticationController {
    private final AuthenticationService authService;
    private final RefreshTokenService refreshTokenService;

    @Autowired
    public AuthenticationController(AuthenticationServiceImpl authService, RefreshTokenService refreshTokenService) {
        this.authService = authService;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginInfoResponse> login(@RequestBody LoginInfoRequest req) {
        LoginInfoResponse resp = authService.login(req);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("refresh-token/{token}")
    public ResponseEntity<TokenRefreshResponse> refreshToken(@PathVariable String token) {
        refreshTokenService.findByToken()

        return null;
    }
}
