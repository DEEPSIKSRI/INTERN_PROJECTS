package com.example.Mapping.Demo.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String error) {
        super(error);

    }
}
