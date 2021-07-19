package com.entropy.backend.models.rests.requests.users;

import com.entropy.backend.common.constants.APIMessage;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor

public class UserOpenFireRegistrationRequest {
    @NotBlank(message = APIMessage.USER_NAME_NOT_BLANK)
    private String username;
    @NotBlank(message = APIMessage.NAME_NOT_BLANK)
    private String name;
    @NotBlank(message = APIMessage.EMAIL_NOT_BLANK)
    private String email;
    private String password;
}
