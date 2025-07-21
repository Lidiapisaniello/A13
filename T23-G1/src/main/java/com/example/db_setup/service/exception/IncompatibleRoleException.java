package com.example.db_setup.service.exception;

import lombok.Getter;

@Getter
public class IncompatibleRoleException extends RuntimeException {
    private final String field;

    public IncompatibleRoleException(String field) {
        this.field = field;
    }

    public IncompatibleRoleException() {
        this.field = "none";
    }
}
