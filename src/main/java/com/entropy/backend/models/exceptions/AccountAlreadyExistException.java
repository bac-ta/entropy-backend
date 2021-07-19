package com.entropy.backend.models.exceptions;

import com.entropy.backend.common.constants.ApiMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountAlreadyExistException extends RuntimeException {
    public AccountAlreadyExistException(String field) {
        super(String.format(ApiMessage.FIELD_ALREADY_EXIST, field));
    }
}
