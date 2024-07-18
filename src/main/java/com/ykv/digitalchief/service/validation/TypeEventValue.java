package com.ykv.digitalchief.service.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TypeEventValidator.class)
public @interface TypeEventValue {
    String message() default "Invalid type event value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}