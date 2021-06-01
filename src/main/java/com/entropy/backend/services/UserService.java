package com.entropy.backend.services;

import com.entropy.backend.models.rests.requests.users.UserRegistrationRequest;
import com.entropy.backend.models.rests.responses.user.UserRegistrationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserRegistrationResponse register(UserRegistrationRequest registration);

    List<Long> findUserRegisterListWaiting();
}
