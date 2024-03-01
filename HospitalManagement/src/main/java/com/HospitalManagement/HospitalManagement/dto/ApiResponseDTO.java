package com.HospitalManagement.HospitalManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ApiResponseDTO {

    private Boolean isSuccess;
    private String message;
    private HttpStatus httpStatus;
    private Object data;

}