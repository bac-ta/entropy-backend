package com.demo.webapp.service;

import com.demo.webapp.entity.Role;
import com.demo.webapp.entity.User;
import com.demo.webapp.enumeration.UserType;
import com.demo.webapp.repository.UserRepository;
import com.demo.webapp.rest.request.UserRegistrationReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author bac-ta
 */
@Service
public class UserService {

    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User regist(UserRegistrationReq registration) {
        User user = User.builder().firstName(registration.getFirstName()).lastName(registration.getLastName())
                .email(registration.getEmail())
                .password(passwordEncoder.encode(registration.getPassword()))
                .roles(Collections.singletonList(new Role(UserType.findByValue(1)))).build();
        return userRepository.save(user);
    }
}
