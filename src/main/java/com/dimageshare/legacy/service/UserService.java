package com.dimageshare.legacy.service;

import com.dimageshare.legacy.dto.UserRegistrationDto;
import com.dimageshare.legacy.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
