package com.entropy.backend.rest.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotBlank;

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
