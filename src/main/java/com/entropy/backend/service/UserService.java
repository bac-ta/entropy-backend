package com.entropy.backend.service;

import com.entropy.backend.constant.APIMessage;
import com.entropy.backend.constant.FormatString;
import com.entropy.backend.entity.Role;
import com.entropy.backend.entity.User;
import com.entropy.backend.enumeration.GenderType;
import com.entropy.backend.enumeration.UserType;
import com.entropy.backend.repository.UserRepository;
import com.entropy.backend.rest.request.UserRegistrationReq;
import com.entropy.backend.rest.response.UserRegistrationResp;
import com.entropy.backend.security.entrypoint.JwtAuthenticationEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

/**
 * @author bac-ta
 */
@Service
public class UserService {

    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);


    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegistrationResp regist(UserRegistrationReq registration) throws Exception {
        User user = User.builder().firstName(registration.getFirstName()).lastName(registration.getLastName())
                .email(registration.getEmail())
                .password(passwordEncoder.encode(registration.getPassword()))
                .userName(registration.getUsername())
                .phoneNumber(registration.getPhoneNumber())
                .genderType(GenderType.findByValue(registration.getGenderType()))
                .dateOfBirth(new SimpleDateFormat(FormatString.DATE_OF_BIRTH_FORMAT).parse(registration.getDateOfBirth()))
                .roles(registration.getUserTypes().stream().map(type -> new Role(UserType.findByValue(type))).collect(Collectors.toSet())).build();
        User userSave = userRepository.save(user);
        Long id = userSave.getId();
        return new UserRegistrationResp(id, APIMessage.REGIST_USER_SUCCESSFUL);
    }
}
