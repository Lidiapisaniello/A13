package com.example.db_setup.service.exception;

import lombok.Getter;

@Getter
public class PasswordResetTokenNotFoundException extends RuntimeException {
    private final String field;

    public PasswordResetTokenNotFoundException(String field) {
        this.field = field;
    }

    public PasswordResetTokenNotFoundException() {
        this.field = "none";
    }
}
