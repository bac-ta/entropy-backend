package com.entropy.backend.models.rests.responses.authentications;

import com.entropy.backend.models.entities.RefreshToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bac-ta
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfoResponse {
    private String message;
    private String accessToken;
    private int statusCode;
    private String refreshToken;
}
