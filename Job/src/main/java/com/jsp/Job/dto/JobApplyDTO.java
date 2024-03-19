package com.jsp.Job.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
public class JobApplyDTO
{
    private long JobId;

    private long applicantId;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    private String middleName;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Sex is required")
    private String sex;

    @NotBlank(message = "Civil status is required")
    private String civilStatus;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @NotBlank(message = "Birth place is required")
    private String birthPlace;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Minimum age must be 18")
    private Integer age;

    @NotBlank(message = "Username is required")
    @Length(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String username;

    @NotBlank(message = "Password is required")
    @Length(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Email address is required")
    @Email(message = "Invalid email address")
    private String emailAddress;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    private String contactNumber;

    private String degree;

    private String applicantPhoto;


    @NotBlank(message = "National ID is required")
    private String nationalId;
}