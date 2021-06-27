package com.entropy.backend.services.impls;

import com.entropy.backend.configurations.securities.jwts.AccountPrincipal;
import com.entropy.backend.models.entities.Permission;
import com.entropy.backend.models.entities.Role;
import com.entropy.backend.models.entities.User;
import com.entropy.backend.models.enumerations.StatusType;
import com.entropy.backend.models.exceptions.ResourceNotFoundExceptionHandler;
import com.entropy.backend.repositories.UserRepository;
import com.entropy.backend.services.UserDetailsServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class implement {@link UserDetailsServiceCustom}
 *
 * @author bac-ta
 * @see UserDetailsImplServiceImpl
 * @since 2021-06-16
 */
@Service
public class UserDetailsImplServiceImpl implements UserDetailsServiceCustom {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsImplServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String emailOrUsername) throws UsernameNotFoundException {
        User user = userRepository.loadUserAndAuthorities(emailOrUsername, (byte) StatusType.ON.getValue());
        String username = user.getUsername();
        String email = user.getEmail();
        String phone = user.getPhone();

        Role role = user.getRole();
        String roleName = role.getName();

        Set<String> permissions = role.getPermissions()
                .stream().map(Permission::getName).collect(Collectors.toSet());

        return AccountPrincipal.create(username, email, phone, roleName, permissions);
    }
}
