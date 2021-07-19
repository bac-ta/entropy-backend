package com.entropy.backend.models.anonations.validators;

import com.entropy.backend.common.App;
import com.entropy.backend.models.anonations.PasswordMatchingWithRepeatPassword;
import com.entropy.backend.models.exceptions.PasswordInvalidException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class handle logic check matching the password and the repeat password
 *
 * @author bac-ta
 * @see PasswordAndRepeatPasswordMatchingValidator
 * @since 2021-06-13
 */
public class PasswordAndRepeatPasswordMatchingValidator implements ConstraintValidator<PasswordMatchingWithRepeatPassword, String> {

    private String passwordFieldName;
    private String repeatPasswordFieldName;

    @Override
    public void initialize(final PasswordMatchingWithRepeatPassword constraintAnnotation) {
        passwordFieldName = constraintAnnotation.password();
        repeatPasswordFieldName = constraintAnnotation.repeatPassword();
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) throws PasswordInvalidException {

        try {
            final String password = BeanUtils.getProperty(value, passwordFieldName);

            if (StringUtils.isBlank(password))
                throw new PasswordInvalidException(String.format(App.ApiMessage.FILED_IS_REQUIRED, "password"));

            Pattern passwordPattern = Pattern.compile(App.Constant.PASSWORD_REGEX);
            Matcher passwordMatcher = passwordPattern.matcher(password);

            int passwordLength = password.length();

            if (passwordLength < App.Constant.MIN_PASSWORD_LENGTH ||
                    passwordLength > App.Constant.MAX_PASSWORD_LENGTH ||
                    !passwordMatcher.matches())
                throw new PasswordInvalidException(App.ApiMessage.PASSWORD_IS_INVALID);

            final CharSequence repeatPassword = BeanUtils.getProperty(value, repeatPasswordFieldName);

            if (StringUtils.isBlank(repeatPassword))
                throw new PasswordInvalidException(String.format(App.ApiMessage.FILED_IS_REQUIRED, "repeatPassword"));

            if (!password.contentEquals(repeatPassword))
                throw new PasswordInvalidException(App.ApiMessage.PASSWORD_NOT_MATCH);
        } catch (final Exception ignore) {
        }

        return true;
    }
}