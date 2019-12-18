package com.demo.webapp.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginInfoResp {
    private String message;
    @JsonProperty(value = "access_token")
    private String accessToken;
}
