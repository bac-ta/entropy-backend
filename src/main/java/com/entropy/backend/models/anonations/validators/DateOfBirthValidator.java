package com.entropy.backend.models.anonations.validators;

import com.entropy.backend.common.App;
import com.entropy.backend.models.anonations.DateOfBirthVerifier;
import com.entropy.backend.models.exceptions.DateOfBirthInvalidException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.GenericValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The class handle logic check validating for date of birth request field
 *
 * @author bac-ta
 * @see GenderValidator
 * @since 2021-06-13
 */
public class DateOfBirthValidator implements ConstraintValidator<DateOfBirthVerifier, String> {
    @Override
    public boolean isValid(String dateOfBirth, ConstraintValidatorContext constraintValidatorContext) throws DateOfBirthInvalidException {
        if (StringUtils.isBlank(dateOfBirth))
            throw new DateOfBirthInvalidException(String.format(App.ApiMessage.FILED_IS_REQUIRED, "dateOfBirth"));

        if (!GenericValidator.isDate(dateOfBirth, App.Constant.DATE_FORMAT, true))
            throw new DateOfBirthInvalidException(String.format(App.ApiMessage.FILED_IS_INVALID, "dateOfBirth"));

        return true;
    }
}
