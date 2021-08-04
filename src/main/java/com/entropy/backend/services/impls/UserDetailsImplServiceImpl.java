package com.entropy.backend.services.impls;

import com.entropy.backend.configurations.securities.jwts.AccountPrincipal;
import com.entropy.backend.models.entities.Role;
import com.entropy.backend.models.entities.User;
import com.entropy.backend.models.enumerations.StatusType;
import com.entropy.backend.models.exceptions.AccountNotFoundException;
import com.entropy.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class implement {@link UserDetailsService}
 *
 * @author bac-ta
 * @see UserDetailsImplServiceImpl
 * @since 2021-06-16
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.loadUserAndAuthoritiesByUsername(username, (byte) StatusType.ON.getValue());
        if (!optionalUser.isPresent())
            throw new AccountNotFoundException(username);

        User userStored = optionalUser.get();
        String email = userStored.getEmail();
        String phone = userStored.getPhone();

        Set<Role> rolesStored = userStored.getRoles();
        Set<String> roleNames = rolesStored.stream().map(role -> role.getName().getName()).collect(Collectors.toSet());

        Set<String> permissionNames = rolesStored.stream().map(role -> role.getPermissions().stream().map(
                permission -> permission.getName().getName()
        ).collect(Collectors.toSet())).flatMap(Collection::stream).collect(Collectors.toSet());

        return AccountPrincipal.create(username, email, phone, roleNames, permissionNames);
    }
}
