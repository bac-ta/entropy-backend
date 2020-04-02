package com.entropy.backend.model.rest.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bac-ta
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationResp {
    private Long id;
    private String message;
}
