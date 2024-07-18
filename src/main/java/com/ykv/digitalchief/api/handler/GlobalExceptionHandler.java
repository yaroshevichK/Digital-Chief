package com.ykv.digitalchief.api.handler;

import com.ykv.digitalchief.api.exception.ErrorMessage;
import com.ykv.digitalchief.api.exception.EventNotFoundException;
import com.ykv.digitalchief.api.exception.TicketNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ErrorMessage errorMessage = new ErrorMessage(BAD_REQUEST.value(), errors.toString());
        return new ResponseEntity<>(errorMessage, BAD_REQUEST);
    }

    @ExceptionHandler(EventNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handlerEventNotFoundException(EventNotFoundException exception) {
        ErrorMessage errorMessage = new ErrorMessage(
                BAD_REQUEST.value(),
                exception.getMessage());
        return new ResponseEntity<>(errorMessage, BAD_REQUEST);
    }

    @ExceptionHandler(TicketNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handlerTicketNotFoundException(TicketNotFoundException exception) {
        ErrorMessage errorMessage = new ErrorMessage(
                BAD_REQUEST.value(),
                exception.getMessage());
        return new ResponseEntity<>(errorMessage, BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorMessage> handleOtherExceptions(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage(
                INTERNAL_SERVER_ERROR.value(),
                e.getMessage()
        );

        return new ResponseEntity<>(errorMessage, INTERNAL_SERVER_ERROR);
    }
}
