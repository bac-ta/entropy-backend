package com.entropy.backend.models.rests.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bac-ta
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationResponse {
    private int statusCode;
    private String message;
}
