package com.entropy.backend.services;

import com.entropy.backend.models.enumerations.UserType;
import com.entropy.backend.models.rests.requests.users.OpenfireUserRegistrationRequest;
import com.entropy.backend.models.rests.requests.users.UserRegistrationRequest;
import com.entropy.backend.models.rests.responses.user.UserRegistrationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface provide methods handle user
 *
 * @author bac-ta
 * @see UserService
 * @since 2021-06-13
 */
@Service
public interface UserService {
    public UserRegistrationResponse register(OpenfireUserRegistrationRequest openfireUserRequest, UserRegistrationRequest userRequest, UserType userType);

    List<String> findUserRegisterListWaiting();

}
