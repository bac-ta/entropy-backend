package com.entropy.backend.models.exceptions;

import com.entropy.backend.common.constants.APIMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String emailOrUsername) {
        super(String.format(APIMessage.ACCOUNT_NOTFOUND, emailOrUsername));
    }
}
