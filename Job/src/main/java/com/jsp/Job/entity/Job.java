package com.jsp.Job.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
@Data
    public class Job {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long jobId;

        private Long companyId;

        private String category;

        private String occupationTitle;

        private Integer reqNoEmployees;

        private Double salaries;

        private String durationEmployment;

        private String qualificationWorkExperience;

        private String jobDescription;

        private String preferredSex;

        private String sectorVacancy;

        private String jobStatus;

        private Date datePosted;

    }