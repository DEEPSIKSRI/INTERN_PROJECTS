package com.jsp.Job.controller;

import com.jsp.Job.api.ApplicantApi;
import com.jsp.Job.dto.FeedBackDTO;
import com.jsp.Job.dto.JobApplyDTO;
import com.jsp.Job.dto.ParticularApplicationDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApplicantController implements ApplicantApi {

    private final ApplicantService applicantService;

    @Override
    public ResponseEntity < ResponseDTO > jobApply ( JobApplyDTO jobApplyDTO ) {
        return applicantService.applyJob ( jobApplyDTO );
    }

    @Override
    public ResponseEntity < ResponseDTO > listOfApplicants ( ) {
        return applicantService.listOfApplicants ( );
    }

    @Override
    public ResponseEntity < ResponseDTO > viewApplication ( ParticularApplicationDTO particularApplicationDTO ) {
        return applicantService.viewApplicant ( particularApplicationDTO );
    }

    @Override
    public ResponseEntity < ResponseDTO > sendFeedBack ( FeedBackDTO feedBackDTO ) {
        return applicantService.feedBackImpl ( feedBackDTO );
    }

    @Override
    public ResponseEntity < ResponseDTO > appliedJobs ( Long applicantId) {
        return applicantService.appliedJobs (applicantId );
    }

    @Override
    public ResponseEntity < ResponseDTO > sendContent ( Long applicantId ) {
        return applicantService.sendHtmlContent(applicantId);
    }
}