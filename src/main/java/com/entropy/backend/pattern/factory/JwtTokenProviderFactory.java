package com.entropy.backend.pattern.factory;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author bac-ta
 */
@Component
public interface JwtTokenProviderFactory {
    String generateToken(Authentication authentication);

    Long getUserIdFromJWT(String token);

    boolean validateToken(String authToken);
}
