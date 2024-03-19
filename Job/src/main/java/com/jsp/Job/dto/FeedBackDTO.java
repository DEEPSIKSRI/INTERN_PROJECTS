package com.jsp.Job.dto;

import lombok.Data;

@Data
public class FeedBackDTO {

    private Long applicantId;

    private Long jobId;

    private boolean pendingApplication;

    private String remarks;


}