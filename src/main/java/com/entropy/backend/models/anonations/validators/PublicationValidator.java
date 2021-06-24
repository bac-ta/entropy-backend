package com.entropy.backend.models.anonations.validators;

import com.entropy.backend.models.anonations.PublicationVerifier;
import com.entropy.backend.models.enumerations.PublicationType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The class handle logic check validating for publication request field
 *
 * @author bac-ta
 * @see GenderValidator
 * @since 2021-06-20
 */
public class PublicationValidator implements ConstraintValidator<PublicationVerifier, String> {
    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        List<String> enumNames = Stream.of(PublicationType.values())
                .map(PublicationType::name)
                .collect(Collectors.toList());

        return enumNames.contains(str);
    }
}
