package com.entropy.backend.services;

import com.entropy.backend.models.enumerations.AccountType;
import com.entropy.backend.models.rests.requests.users.UserRegistrationRequest;
import com.entropy.backend.models.rests.responses.user.UserRegistrationResponse;
import org.springframework.stereotype.Service;

/**
 * Interface provide methods handle user
 *
 * @author bac-ta
 * @see UserService
 * @since 2021-06-13
 */
@Service
public interface UserService {
    UserRegistrationResponse register(UserRegistrationRequest userRequest, AccountType accountType);

}
