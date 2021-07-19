package com.entropy.backend.models.anonations.validators;

import com.entropy.backend.common.App;
import com.entropy.backend.models.anonations.RoleVerifier;
import com.entropy.backend.models.enumerations.RoleType;
import com.entropy.backend.models.exceptions.RoleInvalidException;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The class handle logic check validating for role request field
 *
 * @author bac-ta
 * @see RoleValidator
 * @since 2021-07-19
 */
public class RoleValidator implements ConstraintValidator<RoleVerifier, String> {
    @Override
    public boolean isValid(String role, ConstraintValidatorContext constraintValidatorContext) throws RoleInvalidException {
        if (StringUtils.isBlank(role))
            throw new RoleInvalidException(String.format(App.ApiMessage.FILED_IS_REQUIRED, "role"));

        List<String> enumNames = Stream.of(RoleType.values())
                .map(RoleType::name)
                .collect(Collectors.toList());

        if (!enumNames.contains(role))
            throw new RoleInvalidException(String.format(App.ApiMessage.FILED_IS_INVALID, "role"));

        return true;
    }
}
