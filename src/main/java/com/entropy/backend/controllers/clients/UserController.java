package com.entropy.backend.controllers.clients;

import com.entropy.backend.models.enumerations.UserType;
import com.entropy.backend.models.rests.requests.users.UserRegistrationRequest;
import com.entropy.backend.models.rests.responses.user.UserRegistrationResponse;
import com.entropy.backend.services.UserService;
import com.entropy.backend.services.impls.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Class controller for creates user APIs
 *
 * @author bac-ta
 * @see UserController
 * @since 2021-05-31
 */
@RestController
@RequestMapping("/client/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<UserRegistrationResponse> registerUser(@Valid @RequestBody UserRegistrationRequest req) {
        UserRegistrationResponse resp = userService.register(req, UserType.CLIENT);
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }
}
