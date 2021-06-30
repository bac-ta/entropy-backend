package com.entropy.backend.models.exceptions;

import com.entropy.backend.common.constants.APIMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AccountInvalidException extends RuntimeException {

    public AccountInvalidException(String username) {
        super(String.format(APIMessage.USERNAME_INVALID, username));
    }
}
