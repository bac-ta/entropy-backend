package com.entropy.backend.service;

import com.entropy.backend.constant.APIMessage;
import com.entropy.backend.constant.FormatString;
import com.entropy.backend.model.entity.User;
import com.entropy.backend.enumeration.ApproveType;
import com.entropy.backend.enumeration.GenderType;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.enumeration.UserType;
import com.entropy.backend.repository.UserRepository;
import com.entropy.backend.model.rest.request.user.UserRegistrationReq;
import com.entropy.backend.model.rest.response.user.UserRegistrationResp;
import com.entropy.backend.security.entrypoint.JwtAuthenticationEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setUserName(registration.getUsername());
        user.setPhoneNumber(registration.getPhoneNumber());
        user.setGenderType(GenderType.findByValue(registration.getGenderType()));
        user.setDateOfBirth(new SimpleDateFormat(FormatString.DATE_OF_BIRTH_FORMAT).parse(registration.getDateOfBirth()));
        user.setUserType(UserType.ADMINITRATOR);

        User userSave = userRepository.save(user);
        Long id = userSave.getId();
        logger.info("User id: " + id);
        return new UserRegistrationResp(id, APIMessage.REGIST_USER_SUCCESSFUL);
    }

    public List<Long> findUserRegistListWatting() {
        Optional<List<Long>> optionalIdList = userRepository.findUserRegistListWatting(StatusType.ON.name(), ApproveType.WAITING.name());
        return optionalIdList.isPresent() ? optionalIdList.get() : new ArrayList<>();
    }
}
