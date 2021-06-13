package com.entropy.backend.models.anonations.validators;

import com.entropy.backend.models.anonations.GenderVerifier;
import com.entropy.backend.models.enumerations.GenderType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The class handle logic check validating for gender request field
 *
 * @author bac-ta
 * @see GenderValidator
 * @since 2021-06-13
 */
public class GenderValidator implements ConstraintValidator<GenderVerifier, String> {
    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        List<String> enumNames = Stream.of(GenderType.values())
                .map(GenderType::name)
                .collect(Collectors.toList());

        return enumNames.contains(str);
    }
}
