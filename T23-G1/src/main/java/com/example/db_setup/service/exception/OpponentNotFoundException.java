package com.example.db_setup.service.exception;

import lombok.Getter;

@Getter
public class OpponentNotFoundException extends RuntimeException {
    private final String field;

    public OpponentNotFoundException(String field) {
        this.field = field;
    }

    public OpponentNotFoundException() {
        this.field = "none";
    }
}
