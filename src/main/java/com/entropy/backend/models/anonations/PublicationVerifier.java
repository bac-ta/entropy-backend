package com.entropy.backend.models.anonations;

import com.entropy.backend.models.anonations.validators.PublicationValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation check the publication field request
 *
 * @author bac-ta
 * @see PublicationVerifier
 * @since 2021-06-20
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = PublicationValidator.class)
@Documented
public @interface PublicationVerifier {
    String message() default "";
}
