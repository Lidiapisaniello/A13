package com.example.db_setup.service.exception;

import lombok.Getter;

@Getter
public class UserAlreadyExistsException extends RuntimeException {
    private final String field;

    public UserAlreadyExistsException(String field) {
        this.field = field;
    }

    public UserAlreadyExistsException() {
        this.field = "none";
    }
}
