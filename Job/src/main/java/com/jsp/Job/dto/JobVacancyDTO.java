package com.jsp.Job.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class JobVacancyDTO {

    private Integer companyId;

    private Long jobId;

    @NotBlank(message = "Category is compulsory")
    private String category;

    @NotBlank(message = "OccupationTitle is Mandatory")
    private String occupationTitle;

    private Integer reqNoEmployees;

    private Double salaries;

    private String durationEmployment;

    private String qualificationWorkExperience;

    private String jobDescription;

    private String preferredSex;

    private String sectorVacancy;

    private String status;

}