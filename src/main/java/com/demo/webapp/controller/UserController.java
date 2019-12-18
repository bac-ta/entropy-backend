package com.demo.webapp.controller;

import com.demo.webapp.constant.APIEndpointBase;
import com.demo.webapp.rest.request.UserRegistrationReq;
import com.demo.webapp.rest.response.UserRegistrationResp;
import com.demo.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(APIEndpointBase.USER_ENDPOINT_BASE)
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/regist")
    public ResponseEntity<UserRegistrationResp> registUser(@RequestBody UserRegistrationReq req) {
        UserRegistrationResp resp = userService.regist(req);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
