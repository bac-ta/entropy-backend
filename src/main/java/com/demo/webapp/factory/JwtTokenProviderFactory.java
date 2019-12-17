package com.demo.webapp.factory;

import org.springframework.security.core.Authentication;

/**
 * @author bac-ta
 */
public interface JwtTokenProviderFactory {
    String generateToken(Authentication authentication);

    Long getUserIdFromJWT(String token);

    boolean validateToken(String authToken);
}
