package com.entropy.backend.models.rests.requests.users;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.models.anonations.GenderVerifier;
import com.entropy.backend.models.anonations.PasswordMatchingWithRepeatPassword;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@Builder
public class UserRegistrationRequest extends OpenfireUserRegistrationRequest {
    private String phone;

    @JsonProperty(value = "dateOfBirth", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String dateOfBirth;

    @NotBlank(message = APIMessage.REPEAT_PASSWORD_NOT_BLANK)
    @JsonProperty(value = "repeatPassword", required = true)
    private String repeatPassword;

    @JsonProperty(value = "gender", required = true)
    @GenderVerifier(message = APIMessage.GENDER_INVALID)
    private String gender;

    @JsonProperty(value = "role", required = true)
    private int role;
}
