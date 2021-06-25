package com.entropy.backend.models.exceptions;

import com.entropy.backend.common.constants.APIMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnumNotFoundException extends RuntimeException {
    public EnumNotFoundException(String enumName, int enumValue) {
        super(String.format(APIMessage.RESOURCE_NOT_FOUND, enumName, "value", enumValue));
    }

    public EnumNotFoundException(String enumName, String enumDescription) {
        super(String.format(APIMessage.RESOURCE_NOT_FOUND, enumName, "description", enumDescription));
    }
}
