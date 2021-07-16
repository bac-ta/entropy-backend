package com.entropy.backend.models.rests.requests.users;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.models.anonations.GenderVerifier;
import com.entropy.backend.models.anonations.PasswordMatchingWithRepeatPassword;
import com.entropy.backend.models.anonations.PasswordVerifier;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author bac-ta
 */
@PasswordMatchingWithRepeatPassword.List({
        @PasswordMatchingWithRepeatPassword(first = "password", second = "repeatPassword", message = APIMessage.PASSWORD_NOT_MATCH)
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {
    @JsonProperty(required = true)
    @NotBlank(message = APIMessage.USER_NAME_NOT_BLANK)
    private String username;

    @NotBlank(message = APIMessage.NAME_NOT_BLANK)
    private String name;

    @Email
    @NotBlank(message = APIMessage.EMAIL_NOT_BLANK)
    private String email;

    @NotBlank(message = APIMessage.PASSWORD_NOT_BLANK)
    @PasswordVerifier
    private String password;

    private String phone;

    @JsonProperty(value = "dateOfBirth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String dateOfBirth;

    @NotBlank
    @JsonProperty(value = "repeatPassword")
    private String repeatPassword;

    @NotBlank
    @JsonProperty(value = "gender")
    @GenderVerifier(message = APIMessage.GENDER_INVALID)
    private String gender;

    @NotBlank
    @JsonProperty(value = "role")
    private String role;
}
