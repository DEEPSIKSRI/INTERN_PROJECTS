package com.jsp.Job.dto;

import lombok.Data;

@Data
public class ParticularApplicationDTO {

    private Long applicantId;

    private Long JobId;

    private String category;

    private String occupationTitle;

    private Integer reqNoEmployees;

    private Double salaries;

    private String durationEmployment;

    private String qualificationWorkExperience;

    private String jobDescription;

    private String preferredSex;

    private String sectorVacancy;

    private String applicantName;

    private String address;

    private String contactNo;

    private String email;

    private String sex;

    private Integer age;

    private String status;
}