package com.ykv.digitalchief.api.exception;

public record ErrorMessage(
        int statusCode,
        String message
) {
}
