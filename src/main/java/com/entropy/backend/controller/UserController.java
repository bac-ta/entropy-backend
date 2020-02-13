package com.entropy.backend.controller;

import com.entropy.backend.constant.APIEndpointBase;
import com.entropy.backend.constant.APIMessage;
import com.entropy.backend.rest.request.UserRegistrationReq;
import com.entropy.backend.rest.response.UserRegistrationResp;
import com.entropy.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author bac-ta
 */
@RestController
@RequestMapping(APIEndpointBase.USER_ENDPOINT_BASE)
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/regist")
    public ResponseEntity<UserRegistrationResp> registUser(@Valid @RequestBody UserRegistrationReq req) {
        try {
            UserRegistrationResp resp = userService.regist(req);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new UserRegistrationResp(null, APIMessage.REGIST_USER_FAIL), HttpStatus.BAD_REQUEST);
        }
    }
}
