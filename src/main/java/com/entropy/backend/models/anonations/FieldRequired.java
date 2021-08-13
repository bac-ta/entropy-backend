package com.entropy.backend.models.anonations;

import com.entropy.backend.models.anonations.validators.FieldValidator;
import com.entropy.backend.models.anonations.validators.GenderValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation check the any field request must be not blank (required)
 *
 * @author bac-ta
 * @see GenderVerifier
 * @since 2021-06-13
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RUNTIME)
@Constraint(validatedBy = FieldValidator.class)
@Documented
public @interface FieldRequired {
    String message() default "";

    String fieldName();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
