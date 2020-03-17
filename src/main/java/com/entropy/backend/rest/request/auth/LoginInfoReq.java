package com.entropy.backend.rest.request.auth;

import com.entropy.backend.anonation.PasswordVerifier;
import com.entropy.backend.constant.APIMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author bac-ta
 */
@Data
@AllArgsConstructor
public class LoginInfoReq {
    @JsonProperty(value = "email_or_username", required = true)
    @NotBlank(message = APIMessage.EMAIL_NOT_BLANK)
    private String emailOrUsername;
    @JsonProperty(required = true)
    @NotBlank(message = APIMessage.PASSWORD_NOT_BLANK)
    @PasswordVerifier
    private String password;
}
