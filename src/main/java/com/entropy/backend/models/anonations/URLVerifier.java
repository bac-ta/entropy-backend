package com.entropy.backend.models.anonations;

import com.entropy.backend.models.anonations.validators.URLValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation check the urls (ex: image title url) request
 *
 * @author bac-ta
 * @see URLVerifier
 * @since 2021-06-20
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = URLValidator.class)
@Documented
public @interface URLVerifier {
    String message() default "";
}
