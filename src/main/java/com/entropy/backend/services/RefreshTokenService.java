package com.entropy.backend.services;

import com.entropy.backend.models.entities.RefreshToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Interface provide methods handle refresh token
 *
 * @author bac-ta
 * @see RefreshTokenService
 * @since 2021-06-10
 */
@Service
public interface RefreshTokenService {
    Optional<RefreshToken> findByToken(String token);

    RefreshToken createRefreshToken(String username);

    RefreshToken verifyExpiration(RefreshToken refreshToken);

    int deleteByUsername(String username);
}
