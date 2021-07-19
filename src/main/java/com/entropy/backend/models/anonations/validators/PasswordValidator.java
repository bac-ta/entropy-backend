package com.entropy.backend.models.anonations.validators;

import com.entropy.backend.common.App;
import com.entropy.backend.models.anonations.PasswordVerifier;
import com.entropy.backend.models.exceptions.PasswordInvalidException;
import com.entropy.backend.models.rests.requests.users.UserRegistrationRequest;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class handle logic check matching the password and the repeat password
 *
 * @author bac-ta
 * @see PasswordValidator
 * @since 2021-06-13
 */
public class PasswordValidator implements ConstraintValidator<PasswordVerifier, Object> {

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) throws PasswordInvalidException {
        UserRegistrationRequest request = (UserRegistrationRequest) value;

        String password = request.getPassword();
        if (StringUtils.isBlank(password))
            throw new PasswordInvalidException(String.format(App.ApiMessage.FILED_IS_REQUIRED, "password"));

        Pattern passwordPattern = Pattern.compile(App.Constant.PASSWORD_REGEX);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (!passwordMatcher.matches())
            throw new PasswordInvalidException(App.ApiMessage.PASSWORD_IS_INVALID);

        String repeatPassword = request.getRepeatPassword();
        if (StringUtils.isBlank(repeatPassword))
            throw new PasswordInvalidException(String.format(App.ApiMessage.FILED_IS_REQUIRED, "repeatPassword"));

        if (!password.equals(repeatPassword))
            throw new PasswordInvalidException(App.ApiMessage.PASSWORD_NOT_MATCH);

        return true;
    }
}