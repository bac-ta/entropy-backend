package com.entropy.backend.services.impls;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.exceptions.UserAlreadyExistException;
import com.entropy.backend.models.entities.User;
import com.entropy.backend.models.enumerations.ApproveType;
import com.entropy.backend.models.enumerations.StatusType;
import com.entropy.backend.models.enumerations.UserType;
import com.entropy.backend.models.rests.requests.users.OpenfireUserRegistrationRequest;
import com.entropy.backend.models.rests.requests.users.UserRegistrationRequest;
import com.entropy.backend.models.rests.responses.user.UserRegistrationResponse;
import com.entropy.backend.repositories.UserRepository;
import com.entropy.backend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
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

    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Value("${openfire.host}")
    private String openfireHost;
    @Value("${openfire.rest-secret-key}")
    private String openfireRestSecretKey;
    @Value("${openfire.xmpp-client-connection-port}")
    private Integer xmppClientConnectionPort;
    @Value("${openfire.xmpp-domain}")
    private String xmppDomain;
    @Value("${openfire.xmpp-client-bin-port}")
    private String xmppClientBinPort;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserRegistrationResponse register(OpenfireUserRegistrationRequest openfireUserRequest, UserRegistrationRequest userRequest, UserType userType) {
        String username = userRequest.getUsername();
        String email = userRequest.getEmail();
        String phone = userRequest.getPhone();

        Optional<User> optionalUser = userRepository.findUserExistBy(username, email, phone);
        if (optionalUser.isPresent()) {
            User alreadyUser = optionalUser.get();

            String alreadyUsername = alreadyUser.getUsername();
            if (alreadyUsername.equals(username))
                throw new UserAlreadyExistException("username");

            String alreadyEmail = alreadyUser.getEmail();
            if (alreadyEmail.equals(email))
                throw new UserAlreadyExistException("email");

            String alreadyPhone = alreadyUser.getPhone();
            if (alreadyPhone.equals(phone))
                throw new UserAlreadyExistException("phone");
        }

        //Call openfire rest api
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", openfireRestSecretKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OpenfireUserRegistrationRequest> requestBody = new HttpEntity<>(openfireUserRequest, headers);
        final String openfireRestApiUrl = openfireRestSecretKey + ":" + xmppClientBinPort + "/plugins/restapi/v1/users";
        restTemplate.postForObject(openfireRestApiUrl, requestBody, OpenfireUserRegistrationRequest.class);

        //Update the fields extant

        return new UserRegistrationResponse(id, APIMessage.REGIST_USER_SUCCESSFUL);
    }

    @Override
    public List<String> findUserRegisterListWaiting() {
        Optional<List<String>> optionalIdList = userRepository.findUserRegistListWatting(StatusType.ON.name(), ApproveType.WAITING.name());
        return optionalIdList.isPresent() ? optionalIdList.get() : new ArrayList<>();
    }
}
