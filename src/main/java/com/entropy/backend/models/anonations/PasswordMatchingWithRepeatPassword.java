package com.entropy.backend.models.anonations;

import com.entropy.backend.models.anonations.validators.PasswordAndRepeatPasswordMatchingValidator;

import javax.validation.Payload;
import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author bac-ta
 */
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordAndRepeatPasswordMatchingValidator.class)
@Documented
public @interface PasswordMatchingWithRepeatPassword {
    String message() default "{constraints.field-match}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String first();

    String second();

    @Target({TYPE, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        PasswordMatchingWithRepeatPassword[] value();
    }
}