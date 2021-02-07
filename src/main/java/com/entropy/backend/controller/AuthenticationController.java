package com.entropy.backend.controller;

import com.entropy.backend.common.constant.APIEndpointBase;
import com.entropy.backend.model.rest.request.auth.LoginInfoReq;
import com.entropy.backend.model.rest.response.auth.LoginInfoResp;
import com.entropy.backend.service.AuthenticationService;
import com.entropy.backend.service.impl.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bac-ta
 */
@RestController
@RequestMapping(APIEndpointBase.AUTH_ENDPOINT_BASE)
public class AuthenticationController {
    private final AuthenticationService authService;

    @Autowired
    public AuthenticationController(AuthenticationServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginInfoResp> login(@RequestBody LoginInfoReq req) {
        LoginInfoResp resp = authService.login(req);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
