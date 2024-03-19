package com.jsp.Job.dto;

import lombok.Data;

import java.util.Date;

@Data
public class JobVacancyDetailsDTO {

    private String occupationTitle;

    private String name;

    private String address;

    private Date datePosted;
}