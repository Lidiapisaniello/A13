package com.example.db_setup.service.exception;

import lombok.Getter;

@Getter
public class InvalidRefreshTokenException extends RuntimeException {
    private final String field;

    public InvalidRefreshTokenException(String field) {
        this.field = field;
    }

    public InvalidRefreshTokenException() {
        this.field = "none";
    }
}
