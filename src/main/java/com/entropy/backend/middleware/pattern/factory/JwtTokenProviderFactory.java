package com.entropy.backend.middleware.pattern.factory;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @author bac-ta
 */
@Service
public interface JwtTokenProviderFactory {
    String generateToken(Authentication authentication);

    Long getUserIdFromJWT(String token);

    boolean validateToken(String authToken);
}
