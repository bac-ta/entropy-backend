package com.entropy.backend.models.exceptions;

import com.entropy.backend.common.constants.ApiMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnumNotFoundException extends RuntimeException {
    public EnumNotFoundException(String enumName, int enumValue) {
        super(String.format(ApiMessage.RESOURCE_NOT_FOUND, enumName, "value", enumValue));
    }

    public EnumNotFoundException(String enumName, String enumDescription) {
        super(String.format(ApiMessage.RESOURCE_NOT_FOUND, enumName, "name", enumDescription));
    }
}
