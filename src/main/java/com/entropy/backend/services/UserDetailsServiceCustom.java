package com.entropy.backend.services;

import com.entropy.backend.services.impls.UserDetailsImplServiceImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * This class implement {@link UserDetailsService} that provides method for handling authentication
 *
 * @author bac-ta
 * @see UserDetailsImplServiceImpl
 * @since 2021-06-16
 */
@Service
public interface UserDetailsServiceCustom extends UserDetailsService {
}
