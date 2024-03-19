package com.jsp.Job.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ParticipantsListDTO {

    private String applicant;

    private String jobTitle;

    private Date AppliedDate;

    private String status;
}