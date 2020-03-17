package com.entropy.backend.rest.response.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResp {
    private String message;
}
