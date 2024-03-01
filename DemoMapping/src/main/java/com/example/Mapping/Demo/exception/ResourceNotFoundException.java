package com.example.Mapping.Demo.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String error) {
        super(error);

    }
}
