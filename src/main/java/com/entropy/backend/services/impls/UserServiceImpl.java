package com.entropy.backend.services.impls;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.common.utils.TimeUtil;
import com.entropy.backend.models.entities.Role;
import com.entropy.backend.models.entities.User;
import com.entropy.backend.models.enumerations.GenderType;
import com.entropy.backend.models.exceptions.AccountAlreadyExistException;
import com.entropy.backend.models.exceptions.AccountRoleInvalidException;
import com.entropy.backend.models.rests.requests.users.OpenfireUserRegistrationRequest;
import com.entropy.backend.models.rests.requests.users.UserRegistrationRequest;
import com.entropy.backend.models.rests.responses.user.UserRegistrationResponse;
import com.entropy.backend.repositories.RoleRepository;
import com.entropy.backend.repositories.UserRepository;
import com.entropy.backend.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * This class implement {@link UserService}
 *
 * @author bac-ta
 * @see UserServiceImpl
 * @since 2021-06-13
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Value("${openfire.host}")
    private String openfireHost;
    @Value("${openfire.rest-secret-key}")
    private String openfireRestSecretKey;
    @Value("${openfire.xmpp-client-bin-port}")
    private String xmppClientBinPort;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserRegistrationResponse register(UserRegistrationRequest userRequest) {
        logger.info("user request: ", userRequest);
        String username = userRequest.getUsername();
        String email = userRequest.getEmail();
        String phone = userRequest.getPhone();

        Optional<User> optionalUser = userRepository.findUserExistBy(username, email, phone);
        if (optionalUser.isPresent()) {
            User alreadyUser = optionalUser.get();

            String alreadyUsername = alreadyUser.getUsername();
            if (alreadyUsername.equals(username))
                throw new AccountAlreadyExistException("username");

            String alreadyEmail = alreadyUser.getEmail();
            if (alreadyEmail.equals(email))
                throw new AccountAlreadyExistException("email");

            String alreadyPhone = alreadyUser.getPhone();
            if (StringUtils.isNotBlank(alreadyPhone) && alreadyPhone.equals(phone))
                throw new AccountAlreadyExistException("phone");
        }

        Role role = roleRepository.findById((byte) userRequest.getRole()).orElseThrow(
                () -> new AccountRoleInvalidException(userRequest.getRole()));

        String name = userRequest.getName();
        String password = userRequest.getPassword();

        //Call openfire rest api
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", openfireRestSecretKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<OpenfireUserRegistrationRequest> requestBody = new HttpEntity<>(new OpenfireUserRegistrationRequest(
                username, name, email, password
        ), headers);

        final String openfireRestApiUrl = openfireHost + ":" + xmppClientBinPort + "/plugins/restapi/v1/users";
        restTemplate.postForObject(openfireRestApiUrl, requestBody, OpenfireUserRegistrationRequest.class);

        //Update the fields remaining
        User storedUser = userRepository.findById(username).get();

        logger.info("storedUser: ", storedUser);
        GenderType genderType = GenderType.valueOf(userRequest.getGender());
        storedUser.setGender((byte) genderType.getValue());
        storedUser.setBcryptedPassword(passwordEncoder.encode(userRequest.getPassword()));
        storedUser.setDateOfBirth(TimeUtil.toDate(userRequest.getDateOfBirth()));
        if (StringUtils.isNotBlank(phone))
            storedUser.setPhone(phone);

        storedUser.setRole(role);

        userRepository.save(storedUser);

        return new UserRegistrationResponse(HttpStatus.CREATED.value(), APIMessage.REGISTER_USER_SUCCESSFUL);
    }

}
