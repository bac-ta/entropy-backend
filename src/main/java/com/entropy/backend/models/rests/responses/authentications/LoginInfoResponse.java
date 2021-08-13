package com.entropy.backend.models.rests.responses.authentications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The response class of login API
 *
 * @author bac-ta
 * @see LoginInfoResponse
 * @since 2021-06-21
 */
@Data
@AllArgsConstructor

public class LoginInfoResponse {
    private String message;
    private String accessToken;
    private int statusCode;
    private String refreshToken;
}
