package com.demo.webapp.rest.request;

import com.demo.webapp.constant.APIMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class LoginInfoReq {
    @JsonProperty(required = true)
    @NotBlank(message = APIMessage.EMAIL_NOT_BLANK)
    private String email;
    @JsonProperty(required = true)
    @NotBlank(message = APIMessage.PASSWORD_NOT_BLANK)
    private String password;
}
