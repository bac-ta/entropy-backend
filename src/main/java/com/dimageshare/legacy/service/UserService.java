package com.dimageshare.legacy.service;

import com.dimageshare.legacy.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.dimageshare.legacy.model.User;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
