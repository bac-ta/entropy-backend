package com.entropy.backend.service.impl;

import com.entropy.backend.common.constant.APIMessage;
import com.entropy.backend.common.util.TimeUtil;
import com.entropy.backend.model.enumeration.ApproveType;
import com.entropy.backend.model.enumeration.GenderType;
import com.entropy.backend.model.enumeration.StatusType;
import com.entropy.backend.model.entity.User;
import com.entropy.backend.model.rest.request.user.UserRegistrationRequest;
import com.entropy.backend.model.rest.response.user.UserRegistrationResponse;
import com.entropy.backend.repository.UserRepository;
import com.entropy.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author bac-ta
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserRegistrationResponse register(UserRegistrationRequest registration) {
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setUserName(registration.getUsername());
        user.setPhoneNumber(registration.getPhoneNumber());
        user.setGenderType(GenderType.findByValue(registration.getGenderType()));
        user.setDateOfBirth(TimeUtil.toDateTime(registration.getDateOfBirth()));

        User userSave = userRepository.save(user);
        Long id = userSave.getId();
        logger.info("User id: " + id);
        return new UserRegistrationResponse(id, APIMessage.REGIST_USER_SUCCESSFUL);
    }

    @Override
    public List<Long> findUserRegisterListWatting() {
        Optional<List<Long>> optionalIdList = userRepository.findUserRegistListWatting(StatusType.ON.name(), ApproveType.WAITING.name());
        return optionalIdList.isPresent() ? optionalIdList.get() : new ArrayList<>();
    }
}
