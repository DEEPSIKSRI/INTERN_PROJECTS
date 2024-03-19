package com.jsp.Job.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Id;

import java.util.Date;

@Data
@Entity
public class JobRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    private Integer companyId;

    private Long jobId;

    private Long applicantId;

    private String applicant;

    private Date registrationDate;

    private String remarks;

    private String fileId;

    private boolean pendingApplication;

    private boolean hView;

    private Date dateTimeApproved;

}