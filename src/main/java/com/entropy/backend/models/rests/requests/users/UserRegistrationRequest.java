package com.entropy.backend.models.rests.requests.users;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.models.anonations.FieldMatch;
import com.entropy.backend.models.anonations.PasswordVerifier;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author bac-ta
 */
@FieldMatch.List({
        @FieldMatch(first = "password", second = "repeatPassword", message = APIMessage.PASSWORD_NOT_MATCH)
})
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class UserRegistrationRequest {

    @NotBlank(message = APIMessage.NAME_NOT_BLANK)
    @JsonProperty(value = "name", required = true)
    private String name;

    private String phone;

    @JsonProperty(value = "dateOfBirth", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String dateOfBirth;

    @NotBlank(message = APIMessage.PASSWORD_NOT_BLANK)
    @JsonProperty(required = true)
    @PasswordVerifier
    private String password;

    @NotBlank(message = APIMessage.REPEAT_PASSWORD_NOT_BLANK)
    @JsonProperty(value = "repeatPassword", required = true)
    private String repeatPassword;

    @Email
    @NotBlank(message = APIMessage.EMAIL_NOT_BLANK)
    @JsonProperty(required = true)
    private String email;

    @JsonProperty(value = "username", required = true)
    @NotBlank(message = APIMessage.USER_NAME_NOT_BLANK)
    private String username;

    @JsonProperty(value = "gender", required = true)
    private Byte gender;
}
