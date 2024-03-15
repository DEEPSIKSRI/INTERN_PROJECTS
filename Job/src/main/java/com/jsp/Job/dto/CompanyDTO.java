package com.jsp.Job.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyDTO {


    @NotBlank(message = "Name should not be Null")
    private String name;

    @NotBlank(message = "Address should not be Null")
    private String address;

    @NotBlank(message = "ContactNumber should not be Null")
    private String contactNumber;

}