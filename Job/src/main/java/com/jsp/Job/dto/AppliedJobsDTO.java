package com.jsp.Job.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AppliedJobsDTO {

    private String occupationTittle;

    private String companyName;

    private String address;

    private String status;

    private Date dateOfRemarks;

}