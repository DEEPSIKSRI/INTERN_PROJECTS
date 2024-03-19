package com.jsp.Job.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

@Data
public class CompanyDTO {

    private int companyId;

    @NotBlank(message = "Name should not be Null")
    private String name;

    @NotBlank(message = "Address should not be Null")
    private String address;

    @NotBlank(message = "ContactNumber should not be Null")
    private String contactNumber;

}