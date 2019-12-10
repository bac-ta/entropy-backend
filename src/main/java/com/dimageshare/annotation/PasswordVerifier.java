package com.dimageshare.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = {})
@ReportAsSingleViolation
@Size(min = 8, max = 32)
//@Pattern(regexp = "[a-zA-Z0-9!-/:-@\\[-`{-~]+")
@Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])|(?=.*[a-z])(?=.*[A-Z])(?=.*[!-/:-@\\[-`{-~])|(?=.*[a-z])(?=.*[0-9])(?=.*[!-/:-@\\[-`{-~])|(?=.*[A-Z])(?=.*[0-9])(?=.*[!-/:-@\\[-`{-~]))[a-zA-Z0-9!-/:-@\\[-`{-~]{0,1000}")
public @interface PasswordVerifier {
    String message() default "{com.entropydb.annotation.PasswordVerifier.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
