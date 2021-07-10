package com.entropy.backend.common.utils;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailUtil {
    public static boolean isEmail(String value) {
        return EmailValidator.getInstance().isValid(value);
    }
}
