package com.Project.VendorProject.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String error) {
        super(error);

    }
}
