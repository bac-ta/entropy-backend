package com.entropy.backend.controller;

import com.entropy.backend.common.constant.APIEndpointBase;
import com.entropy.backend.common.constant.APIMessage;
import com.entropy.backend.model.rest.request.user.UserRegistrationRequest;
import com.entropy.backend.model.rest.response.user.UserRegistrationResponse;
import com.entropy.backend.service.UserService;
import com.entropy.backend.service.impl.UserServiceImpl;
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
 * @author bac-ta
 */
@RestController
@RequestMapping(APIEndpointBase.USER_ENDPOINT_BASE)
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/regist")
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

    @GetMapping("/ids-watting")
    public ResponseEntity<List<Long>> findUserRegisterListWaiting() {
        List<Long> idList = userService.findUserRegisterListWatting();
        return new ResponseEntity<>(idList, HttpStatus.OK);
    }
}
