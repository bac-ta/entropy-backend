package com.demo.webapp.controller;

import com.demo.webapp.constant.APIEndpointBase;
import com.demo.webapp.rest.request.LoginInfoReq;
import com.demo.webapp.rest.response.LoginInfoResp;
import com.demo.webapp.service.AuthenticationService;
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
    private AuthenticationService authService;

    @Autowired
    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginInfoResp> login(@RequestBody LoginInfoReq req) {
        LoginInfoResp resp = authService.login(req);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
