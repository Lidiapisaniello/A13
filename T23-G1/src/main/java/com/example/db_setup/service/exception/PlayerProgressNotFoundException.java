package com.example.db_setup.service.exception;

import lombok.Getter;

@Getter
public class PlayerProgressNotFoundException extends RuntimeException {
    private final String field;

    public PlayerProgressNotFoundException(String field) {
        this.field = field;
    }

    public PlayerProgressNotFoundException() {
        this.field = "none";
    }
}
