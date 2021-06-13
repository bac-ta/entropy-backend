package com.entropy.backend.models.anonations.validators;

import com.entropy.backend.models.anonations.PasswordMatchingWithRepeatPassword;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The class handle logic check matching the password and the repeat password
 *
 * @author bac-ta
 * @see PasswordAndRepeatPasswordMatchingValidator
 * @since 2021-06-13
 */
public class PasswordAndRepeatPasswordMatchingValidator implements ConstraintValidator<PasswordMatchingWithRepeatPassword, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final PasswordMatchingWithRepeatPassword constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try {
            final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
            final Object secondObj = BeanUtils.getProperty(value, secondFieldName);
            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        } catch (final Exception ignore) {
        }
        return true;
    }
}