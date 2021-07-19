package com.entropy.backend.services.impls;

import com.entropy.backend.common.constants.ApiMessage;
import com.entropy.backend.models.entities.RefreshToken;
import com.entropy.backend.models.exceptions.RefreshTokenException;
import com.entropy.backend.repositories.RefreshTokenRepository;
import com.entropy.backend.services.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * This class implement {@link RefreshTokenService}
 *
 * @author bac-ta
 * @see RefreshTokenServiceImpl
 * @since 2021-06-10
 */
@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    @Value("${app.auth.refresh-token-expiration-msec}")
    private long refreshTokenExpire;

    @Autowired
    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    @Override
    public RefreshToken createRefreshToken(String username) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUsername(username);
        refreshToken.setExpiryDate(System.currentTimeMillis() + refreshTokenExpire);
        refreshToken.setToken(UUID.randomUUID().toString());

        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public RefreshToken verifyExpiration(RefreshToken refreshToken) {
        if (refreshToken.getExpiryDate().compareTo(System.currentTimeMillis()) < 0) {
            refreshTokenRepository.delete(refreshToken);
            throw new RefreshTokenException(refreshToken.getToken(), ApiMessage.REFRESH_TOKEN_EXPIRE);
        }

        return refreshToken;
    }

    @Override
    public int deleteByUsername(String username) {
        return refreshTokenRepository.deleteByUsername(username);
    }
}
