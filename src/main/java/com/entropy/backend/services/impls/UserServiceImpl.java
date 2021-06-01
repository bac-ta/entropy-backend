package com.entropy.backend.services.impls;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.common.utils.TimeUtil;
import com.entropy.backend.models.entities.User;
import com.entropy.backend.models.enumerations.ApproveType;
import com.entropy.backend.models.enumerations.GenderType;
import com.entropy.backend.models.enumerations.StatusType;
import com.entropy.backend.models.rests.requests.users.UserRegistrationRequest;
import com.entropy.backend.models.rests.responses.user.UserRegistrationResponse;
import com.entropy.backend.repositories.UserRepository;
import com.entropy.backend.services.UserService;
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
        user.setName(registration.getName());
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
    public List<Long> findUserRegisterListWaiting() {
        Optional<List<Long>> optionalIdList = userRepository.findUserRegistListWatting(StatusType.ON.name(), ApproveType.WAITING.name());
        return optionalIdList.isPresent() ? optionalIdList.get() : new ArrayList<>();
    }
}
