package com.entropy.backend.models.exceptions;

import com.entropy.backend.common.constants.APIMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountRoleInvalidException extends RuntimeException {
    public AccountRoleInvalidException(int role) {
        super(String.format(APIMessage.RESOURCE_NOT_FOUND, "Account role", "role", role));
    }
}
