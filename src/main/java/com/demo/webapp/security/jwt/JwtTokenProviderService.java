package com.demo.webapp.security.jwt;

import org.springframework.security.core.Authentication;

public interface JwtTokenProviderService {
    String generateToken(Authentication authentication);

    String getUserIdFromJWT(String token);

    boolean validateToken(String authToken);
}
