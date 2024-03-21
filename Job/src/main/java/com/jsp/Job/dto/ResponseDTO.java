package com.jsp.Job.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

        private Boolean isSuccess;
        private HttpStatus status;
        private String message;
        private Object data;

}