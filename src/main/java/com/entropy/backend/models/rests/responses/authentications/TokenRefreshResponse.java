package com.entropy.backend.models.rests.responses.authentications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The response class of refresh token API
 *
 * @author bac-ta
 * @see TokenRefreshResponse
 * @since 2021-06-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenRefreshResponse {
    private String accessToken;
    private String refreshToken;
    private String type = "Bearer";
}
