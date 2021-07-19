package com.entropy.backend.models.anonations;

import com.entropy.backend.models.anonations.validators.RoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation check the user role request
 *
 * @author bac-ta
 * @see RoleVerifier
 * @since 2021-07-19
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = RoleValidator.class)
@Documented
public @interface RoleVerifier {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
