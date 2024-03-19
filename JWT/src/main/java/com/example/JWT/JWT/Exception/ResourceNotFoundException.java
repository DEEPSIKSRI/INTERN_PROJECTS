package com.example.JWT.JWT.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String error) {
        super(error);

    }
}
