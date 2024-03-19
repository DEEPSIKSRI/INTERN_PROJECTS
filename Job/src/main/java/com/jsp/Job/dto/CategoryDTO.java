package com.jsp.Job.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDTO {

    @NotBlank(message = "CategoryName is Compulsory")
    private String categoryName;
}