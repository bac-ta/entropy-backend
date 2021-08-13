package com.entropy.backend.patterns.factories;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @author bac-ta
 */
@Component
public interface JwtTokenProviderFactory {
    String generateToken(Authentication authentication);

    String generateToken(String emailOrUsername);

    String getUsernameFromJWT(String token);

    boolean validateToken(String authToken);
}
