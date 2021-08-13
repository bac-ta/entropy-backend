package com.entropy.backend.models.exceptions;

import com.entropy.backend.common.constants.ApiMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String emailOrUsername) {
        super(String.format(ApiMessage.ACCOUNT_NOTFOUND, emailOrUsername));
    }
}
