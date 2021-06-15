package com.entropy.backend.services.impls;

import com.entropy.backend.configurations.securities.jwts.AccountPrincipal;
import com.entropy.backend.exceptions.ResourceNotFoundExceptionHandler;
import com.entropy.backend.models.entities.User;
import com.entropy.backend.models.enumerations.StatusType;
import com.entropy.backend.models.enumerations.UserType;
import com.entropy.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bac-ta
 */
@Service
public class UserDetailsImplServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsImplServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String emailOrUsername) throws UsernameNotFoundException {
        User user = userRepository.findUser(emailOrUsername, (byte) StatusType.ON.getValue(), (byte) UserType.ADMINISTRATOR.getValue());
        return AccountPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptionHandler("Account", "id", id));
        return AccountPrincipal.create(user);
    }
}
