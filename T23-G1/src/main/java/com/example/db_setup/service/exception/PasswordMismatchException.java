package com.example.db_setup.service.exception;

import lombok.Getter;

@Getter
public class PasswordMismatchException extends RuntimeException {
    private final String field;

    public PasswordMismatchException(String field) {
        this.field = field;
    }

    public PasswordMismatchException() {
        this.field = "none";
    }
}
