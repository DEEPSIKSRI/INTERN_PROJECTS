package com.jsp.Job.api;

import com.jsp.Job.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applicant")
public interface ApplicantApi {

    @PreAuthorize( "hasAnyRole('USER')" )
    @PostMapping("/jobApply")
    ResponseEntity < ResponseDTO > jobApply( @RequestBody JobApplyDTO jobApplyDTO );

    @PreAuthorize ( "hasAnyRole('ADMIN')" )
    @GetMapping("/listOfApplicants")
    ResponseEntity<ResponseDTO> listOfApplicants();

    @PreAuthorize ( "hasAnyRole('ADMIN')" )
    @GetMapping("/viewApplication")
    ResponseEntity<ResponseDTO> viewApplication( @RequestBody ParticularApplicationDTO particularApplicationDTO );

    @PreAuthorize ( "hasAnyRole('ADMIN')" )
    @PostMapping("/sendFeedBack")
    ResponseEntity<ResponseDTO> sendFeedBack( @RequestBody FeedBackDTO feedBackDTO );

    @PreAuthorize ( "hasAnyRole('USER')" )
    @GetMapping("/appliedJobsAndMessages/{applicantId}")
    ResponseEntity<ResponseDTO> appliedJobs( @PathVariable Long applicantId );

    @PreAuthorize ( "hasAnyRole('ADMIN')" )
    @PostMapping("/sendContent/{applicantId}")
    ResponseEntity<ResponseDTO> sendContent(@PathVariable Long applicantId);

    @PreAuthorize ( "hasAnyRole('ADMIN','USER')" )
    @GetMapping  ("/getAll")
    ResponseEntity<ResponseDTO> getAll();
}