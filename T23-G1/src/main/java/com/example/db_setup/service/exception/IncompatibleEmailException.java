package com.example.db_setup.service.exception;

import lombok.Getter;

@Getter
public class IncompatibleEmailException extends RuntimeException {
    private final String field;

    public IncompatibleEmailException(String field) {
        this.field = field;
    }

    public IncompatibleEmailException() {
        this.field = "none";
    }
}
