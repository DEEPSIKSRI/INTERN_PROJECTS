package com.jsp.Job.api;

import com.jsp.Job.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applicant")
public interface ApplicantApi {

    @PostMapping("/jobApply")
    ResponseEntity < ResponseDTO > jobApply( @RequestBody JobApplyDTO jobApplyDTO );

    @GetMapping("/listOfApplicants")
    ResponseEntity<ResponseDTO> listOfApplicants();

    @GetMapping("/viewApplication")
    ResponseEntity<ResponseDTO> viewApplication( @RequestBody ParticularApplicationDTO particularApplicationDTO );

    @PostMapping("/sendFeedBack")
    ResponseEntity<ResponseDTO> sendFeedBack( @RequestBody FeedBackDTO feedBackDTO );

    @GetMapping("/appliedJobsAndMessages/{applicantId}")
    ResponseEntity<ResponseDTO> appliedJobs( @PathVariable Long applicantId );

    @PostMapping("/sendContent/{applicantId}")
    ResponseEntity<ResponseDTO> sendContent(@PathVariable Long applicantId);
}