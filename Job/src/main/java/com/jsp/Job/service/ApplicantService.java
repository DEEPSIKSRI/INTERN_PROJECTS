package com.jsp.Job.service;

import com.jsp.Job.dto.FeedBackDTO;
import com.jsp.Job.dto.JobApplyDTO;
import com.jsp.Job.dto.ParticularApplicationDTO;
import com.jsp.Job.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ApplicantService {

    ResponseEntity < ResponseDTO > applyJob ( JobApplyDTO jobApplyDTO );

    ResponseEntity< ResponseDTO> listOfApplicants ( );

    ResponseEntity< ResponseDTO> viewApplicant ( ParticularApplicationDTO particularApplicationDTO );

    ResponseEntity< ResponseDTO> feedBackImpl ( FeedBackDTO feedBackDTO );

    ResponseEntity< ResponseDTO> appliedJobs (Long applicantId );

    ResponseEntity< ResponseDTO> sendHtmlContent ( Long applicantId );

    ResponseEntity< ResponseDTO> fetchAll ( );
}