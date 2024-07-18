package com.ykv.digitalchief.service.validation;

import com.ykv.digitalchief.util.ArgEventValidTypeTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TypeTicketValidatorTest {

    @InjectMocks
    private TypeTicketValidator typeTicketValidator;


    @ParameterizedTest
    @DisplayName("Validation type ticket")
    @ArgumentsSource(ArgEventValidTypeTicket.class)
    void shouldReturnValidTypeTicket(String typeTicket, boolean isValid) {
        Assertions.assertEquals(typeTicketValidator.isValid(typeTicket, null), isValid);
    }

}