package com.demo.webapp.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class LoginInfoResp {
    private String message;
    private HttpStatus status;
    @JsonProperty(value = "access_token")
    private String accessToken;
}
