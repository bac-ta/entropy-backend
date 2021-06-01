package com.entropy.backend.models.rests.requests.users;

import com.entropy.backend.common.constants.APIMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOpenFireRegistrationRequest {
    @NotBlank(message = APIMessage.USER_NAME_NOT_BLANK)
    private String username;
    @NotBlank(message = APIMessage.NAME_NOT_BLANK)
    private String name;
    @NotBlank(message = APIMessage.EMAIL_NOT_BLANK)
    private String email;
    @NotBlank(message = APIMessage.PASSWORD_NOT_BLANK)
    private String password;
}
