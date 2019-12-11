package com.dimageshare.entity.rest.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author bac-ta
 */
@Data
public class AccountLoginResp {
    private String message;
    private HttpStatus status;

    public AccountLoginResp(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
