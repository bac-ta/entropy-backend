package com.entropy.backend.models.exceptions;

import com.entropy.backend.common.App;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FieldException extends ValidationException {
    public FieldException(String fieldName) {
        super(String.format(App.ApiMessage.FILED_IS_REQUIRED, fieldName));
    }
}
