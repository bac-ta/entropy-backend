package com.entropy.backend.controllers;

import com.entropy.backend.common.constants.ApiEndpointBase;
import com.entropy.backend.models.rests.requests.authentications.LoginInfoRequest;
import com.entropy.backend.models.rests.responses.authentications.LoginInfoResponse;
import com.entropy.backend.services.AuthenticationService;
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
@RequestMapping(ApiEndpointBase.AUTH_URL_BASE)
public class AuthenticationController {
    private final AuthenticationService authService;

    @Autowired
    public AuthenticationController(AuthenticationServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginInfoResponse> login(@RequestBody LoginInfoRequest req) {
        LoginInfoResponse response = authService.login(req);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("refresh-token/{token}")
    public ResponseEntity<LoginInfoResponse> refreshToken(@PathVariable String token) {
        LoginInfoResponse response = authService.refreshToken(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/logout/{username}")
    public ResponseEntity<Void> logout(@PathVariable String username) {
        authService.logout(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
