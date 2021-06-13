package com.entropy.backend.models.rests.requests.users;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.models.anonations.PasswordVerifier;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Class map with user request of Openfire Rest API
 *
 * @author bac-ta
 * @see OpenfireUserRegistrationRequest
 * @since 2021-06-13
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@MappedSuperclass
public class OpenfireUserRegistrationRequest {
    @JsonProperty(required = true)
    @NotBlank(message = APIMessage.USER_NAME_NOT_BLANK)
    private String username;

    @NotBlank(message = APIMessage.NAME_NOT_BLANK)
    @JsonProperty(required = true)
    private String name;

    @Email
    @NotBlank(message = APIMessage.EMAIL_NOT_BLANK)
    @JsonProperty(required = true)
    private String email;

    @NotBlank(message = APIMessage.PASSWORD_NOT_BLANK)
    @JsonProperty(required = true)
    @PasswordVerifier
    private String password;
}
