package com.jsp.Job.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank(message = "Name is Mandatory")
    private String fullName;

    @NotBlank(message = "Username is Mandatory")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Password is Mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$", message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character")
    private String password;

    @NotBlank(message = "Role is Mandatory")
    private String role;

    @NotBlank(message = "Pic Location is Mandatory")
    private String picLocation;
}