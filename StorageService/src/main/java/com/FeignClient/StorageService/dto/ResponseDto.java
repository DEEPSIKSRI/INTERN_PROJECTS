package com.FeignClient.StorageService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseDto {

    private HttpStatus httpStatus;

    private String message;

    private Object data;
}
