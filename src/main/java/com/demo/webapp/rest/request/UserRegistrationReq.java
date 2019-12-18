package com.demo.webapp.rest.request;

import com.demo.webapp.anonation.FieldMatch;
import com.demo.webapp.constant.APIMessage;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author bac-ta
 */
@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = APIMessage.PASSWORD_NOT_MATCH),
        @FieldMatch(first = "email", second = "confirmEmail", message = APIMessage.EMAIL_NOT_MATCH)
})
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class UserRegistrationReq {

    @NotBlank(message = APIMessage.FIRST_NAME_NOT_BLANK)
    @JsonProperty(value = "first_name", required = true)
    private String firstName;

    @NotBlank(message = APIMessage.LAST_NAME_NOT_BLANK)
    @JsonProperty(value = "last_name", required = true)
    private String lastName;

    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    @JsonProperty(value = "date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String dateOfBirth;

    @NotBlank(message = APIMessage.PASSWORD_NOT_BLANK)
    @JsonProperty(required = true)
    private String password;

    @NotBlank(message = APIMessage.CONFIRM_PASSWORD_NOT_BLANK)
    @JsonProperty(value = "confirm_password", required = true)
    private String confirmPassword;

    @Email
    @NotBlank(message = APIMessage.EMAIL_NOT_BLANK)
    @JsonProperty(required = true)
    private String email;

    @Email
    @NotBlank(message = APIMessage.CONFIRM_EMAIL_NOT_BLANK)
    @JsonProperty(required = true)
    private String confirmEmail;

    @JsonProperty(required = true)
    @NotBlank(message = APIMessage.USER_NAME_NOT_BLANK)
    private String username;

    @JsonProperty(value = "gender_type", defaultValue = "0")
    private Integer genderType;

    @NotBlank(message = APIMessage.USER_TYPE_NOT_BLANK)
    @JsonProperty(value = "user_types", required = true)
    private List<Integer> userTypes;
}
