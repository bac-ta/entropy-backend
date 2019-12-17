package com.demo.webapp.service;

import com.demo.webapp.entity.User;
import com.demo.webapp.repository.UserRepository;
import com.demo.webapp.security.jwt.AccountPrincipal;
import com.demo.webapp.util.ResourceNotFoundExceptionHandler;
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
public class AuthenticationService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        return AccountPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptionHandler("Account", "id", id));
        return AccountPrincipal.create(user);
    }
}
