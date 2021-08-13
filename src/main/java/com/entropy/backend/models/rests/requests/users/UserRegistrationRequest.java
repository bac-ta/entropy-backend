package com.entropy.backend.models.rests.requests.users;

import com.entropy.backend.models.anonations.DateOfBirthVerifier;
import com.entropy.backend.models.anonations.GenderVerifier;
import com.entropy.backend.models.anonations.PasswordVerifier;
import com.entropy.backend.models.anonations.RoleVerifier;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author bac-ta
 */
@PasswordVerifier.List({
        @PasswordVerifier(password = "password", repeatPassword = "repeatPassword")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest extends OpenfireUserRegistrationRequest {

    private String phone;

    @JsonProperty(value = "dateOfBirth")
    @DateOfBirthVerifier
    private String dateOfBirth;

    @NotBlank
    @JsonProperty(value = "repeatPassword")
    private String repeatPassword;

    @JsonProperty(value = "gender")
    @GenderVerifier
    private String gender;
}
