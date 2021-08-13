package com.entropy.backend.models.rests.requests.users;

import com.entropy.backend.common.constants.ApiMessage;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor

public class UserOpenFireRegistrationRequest {
    @NotBlank(message = ApiMessage.USER_NAME_NOT_BLANK)
    private String username;
    @NotBlank(message = ApiMessage.NAME_NOT_BLANK)
    private String name;
    @NotBlank(message = ApiMessage.EMAIL_NOT_BLANK)
    private String email;
    private String password;
}
