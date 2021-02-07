package com.entropy.backend.service;

import com.entropy.backend.model.rest.request.user.UserRegistrationReq;
import com.entropy.backend.model.rest.response.user.UserRegistrationResp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserRegistrationResp regist(UserRegistrationReq registration);

    List<Long> findUserRegistListWatting();
}
