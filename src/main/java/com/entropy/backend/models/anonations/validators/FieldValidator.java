package com.entropy.backend.models.anonations.validators;

import com.entropy.backend.models.anonations.FieldRequired;
import com.entropy.backend.models.exceptions.FieldException;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The class handle logic check validating for any request field that must be not blank (required)
 *
 * @author bac-ta
 * @see FieldValidator
 * @since 2021-07-19
 */
public class FieldValidator implements ConstraintValidator<FieldRequired, String> {
    private String fieldName;

    @Override
    public void initialize(final FieldRequired constraintAnnotation) {
        fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) throws FieldException {
        if (StringUtils.isBlank(value))
            throw new FieldException(fieldName);

        return true;
    }
}
