package com.FeignClient.DataService.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException ( String idNotFound ) {
        super(idNotFound);
    }
}
