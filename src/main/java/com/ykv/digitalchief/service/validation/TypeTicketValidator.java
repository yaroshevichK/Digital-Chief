package com.ykv.digitalchief.service.validation;

import com.ykv.digitalchief.persistence.entity.TypeTicket;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TypeTicketValidator implements ConstraintValidator<TypeTicketValue, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        Set<String> values = Stream.of(TypeTicket.values())
                .map(Enum::name)
                .collect(Collectors.toSet());
        return values.contains(value);
    }
}