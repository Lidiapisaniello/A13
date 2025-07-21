package com.example.db_setup.service.exception;

import lombok.Getter;

@Getter
public class ServiceNotAvailableException extends RuntimeException {
    private final String field;

    public ServiceNotAvailableException(String field) {
        this.field = field;
    }

    public ServiceNotAvailableException() {
        this.field = "none";
    }
}
