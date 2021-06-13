package com.entropy.backend.controllers;

import com.entropy.backend.common.constants.APIEndpointBase;
import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.models.rests.requests.users.UserRegistrationRequest;
import com.entropy.backend.models.rests.responses.user.UserRegistrationResponse;
import com.entropy.backend.services.UserService;
import com.entropy.backend.services.impls.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Class controller for creates user APIs
 *
 * @author bac-ta
 * @see UserController
 * @since 2021-05-31
 */
@RestController
@RequestMapping(APIEndpointBase.USER_ENDPOINT_BASE)
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<UserRegistrationResponse> registerUser(@Valid @RequestBody UserRegistrationRequest req) {
        try {
            UserRegistrationResponse resp = userService.register(req);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception e) {
            UserRegistrationResponse resp = new UserRegistrationResponse();
            resp.setMessage(APIMessage.REGIST_USER_FAIL);
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        }
    }
}
