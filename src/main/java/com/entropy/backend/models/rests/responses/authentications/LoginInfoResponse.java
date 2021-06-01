package com.entropy.backend.models.rests.responses.authentications;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author bac-ta
 */
@Data
@AllArgsConstructor
public class LoginInfoResponse {
    private String message;
    @JsonProperty(value = "accessToken")
    private String accessToken;
    @JsonProperty(value = "statusCode")
    private int statusCode;
}
