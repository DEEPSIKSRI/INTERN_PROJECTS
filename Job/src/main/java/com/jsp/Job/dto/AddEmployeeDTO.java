package com.jsp.Job.dto;

import jakarta.validation.constraints.*;

import lombok.Data;

import java.util.Date;

@Data
public class AddEmployeeDTO {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    private String middleName;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull(message = "Birthdate is required")
    @Past(message = "Birthdate must be in the past")
    private Date birthdate;

    @NotBlank(message = "Birthplace is required")
    private String birthplace;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Minimum age must be 18")
    private Integer age;

    @NotBlank(message = "Sex is required")
    private String sex;

    @NotBlank(message = "Civil status is required")
    private String civilStatus;

    @NotBlank(message = "Position is required")
    private String position;

    @NotBlank(message = "Email address is required")
    @Email(message = "Invalid email address")
    private String empEmailAddress;

    @NotBlank(message = "Cell number is required")
    @Pattern(regexp = "\\d{10}", message = "Cell number must be 10 digits")
    private String cellNo;

    @NotBlank(message = "Company name is required")
    private String companyName;
}