package com.entropy.backend.models.rests.requests.authentications;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.models.anonations.PasswordVerifier;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author bac-ta
 */
@Data
@AllArgsConstructor
public class LoginInfoRequest {
    @JsonProperty(required = true)
    @NotBlank(message = APIMessage.EMAIL_NOT_BLANK)
    private String username;
    @JsonProperty(required = true)
    @NotBlank(message = APIMessage.PASSWORD_NOT_BLANK)
    @PasswordVerifier
    private String password;
}
