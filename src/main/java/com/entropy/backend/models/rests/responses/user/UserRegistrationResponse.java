package com.entropy.backend.models.rests.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author bac-ta
 */
@Data
@AllArgsConstructor
public class UserRegistrationResponse {
    private int status;
    private String message;
}
