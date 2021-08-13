package com.entropy.backend.models.anonations.validators;

import com.entropy.backend.models.anonations.URLVerifier;
import org.apache.commons.validator.routines.UrlValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The class handle logic check validating for urls request field
 *
 * @author bac-ta
 * @see URLValidator
 * @since 2021-06-20
 */
public class URLValidator implements ConstraintValidator<URLVerifier, String> {
    @Override
    public void initialize(URLVerifier constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext constraintValidatorContext) {
        UrlValidator validator = new UrlValidator();
        return validator.isValid(url);
    }
}
