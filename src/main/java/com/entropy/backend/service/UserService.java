package com.entropy.backend.service;

import com.entropy.backend.model.rest.request.user.UserRegistrationRequest;
import com.entropy.backend.model.rest.response.user.UserRegistrationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserRegistrationResponse register(UserRegistrationRequest registration);

    List<Long> findUserRegisterListWatting();
}
