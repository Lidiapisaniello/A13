package com.example.db_setup.controller.advice;

import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandler {
    private final MessageSource messageSource;

    public ValidationExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex, Locale locale) {
        List<Map<String, String>> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> {
                    String localizedMessage = messageSource.getMessage(error, locale);
                    return Map.of(
                            "field", error.getField(),
                            "message", localizedMessage
                    );
                })
                .toList();

        return ResponseEntity.badRequest().body(Map.of(
                //"status", 400,
                //"error", "Bad Request",
                //"message", "Validation failed",
                "errors", errors
        ));
    }
}

