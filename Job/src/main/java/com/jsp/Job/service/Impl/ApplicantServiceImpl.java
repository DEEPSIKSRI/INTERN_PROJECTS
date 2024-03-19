package com.jsp.Job.service.Impl;

import com.jsp.Job.dto.*;
import com.jsp.Job.entity.Applicant;
import com.jsp.Job.entity.Company;
import com.jsp.Job.entity.Job;
import com.jsp.Job.entity.JobRegistration;
import com.jsp.Job.repository.service.ApplicantServiceRepo;
import com.jsp.Job.repository.service.CompanyServiceRep;
import com.jsp.Job.repository.service.JobRegistrationServiceRepo;
import com.jsp.Job.repository.service.JobServiceRepo;
import com.jsp.Job.service.ApplicantService;
import com.jsp.Job.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantServiceRepo applicantServiceRepo;
    private final JobRegistrationServiceRepo jobRegistrationServiceRepo;
    private final JobServiceRepo jobServiceRepo;
    private final CompanyServiceRep companyServiceRep;

    @Override
    public ResponseEntity < ResponseDTO > applyJob ( JobApplyDTO jobApplyDTO ) {

        if ( jobRegistrationServiceRepo.existsByApplicantIdAndJobId ( jobApplyDTO.getApplicantId ( ) , jobApplyDTO.getJobId ( ) ) ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "Application is Already submitted" , "" ) );
        }


        Optional < Job > optionalJob = jobServiceRepo.findById ( jobApplyDTO.getJobId ( ) );

        Job job = optionalJob.orElseThrow ( ( ) -> new IllegalArgumentException ( "Job not found" ) );


        Applicant applicant1 = new Applicant ( );
        applicant1.setApplicantId ( jobApplyDTO.getApplicantId ( ) );
        applicant1.setBirthPlace ( jobApplyDTO.getBirthPlace ( ) );
        applicant1.setDegree ( jobApplyDTO.getDegree ( ) );
        applicant1.setApplicantPhoto ( jobApplyDTO.getApplicantPhoto ( ) );
        applicant1.setCivilStatus ( jobApplyDTO.getCivilStatus ( ) );
        applicant1.setEmailAddress ( jobApplyDTO.getEmailAddress ( ) );
        applicant1.setContactNumber ( jobApplyDTO.getContactNumber ( ) );
        applicant1.setSex ( jobApplyDTO.getSex ( ) );
        applicant1.setFirstName ( jobApplyDTO.getFirstName ( ) );
        applicant1.setAge ( jobApplyDTO.getAge ( ) );
        applicant1.setPassword ( jobApplyDTO.getPassword ( ) );
        applicant1.setUsername ( jobApplyDTO.getUsername ( ) );
        applicant1.setAddress ( jobApplyDTO.getAddress ( ) );
        applicant1.setLastName ( jobApplyDTO.getLastName ( ) );
        applicant1.setBirthDate ( jobApplyDTO.getBirthDate ( ) );
        applicant1.setNationalId ( jobApplyDTO.getNationalId ( ) );
        applicantServiceRepo.save ( applicant1 );

        Timestamp currentTimestamp = new Timestamp ( System.currentTimeMillis ( ) );
        JobRegistration jobRegistration = new JobRegistration ( );
        jobRegistration.setJobId ( job.getJobId ( ) );
        jobRegistration.setApplicant ( jobApplyDTO.getFirstName ( ) );
        jobRegistration.setRegistrationDate ( currentTimestamp );
        jobRegistration.setApplicantId ( jobApplyDTO.getApplicantId ( ) );
        jobRegistration.setCompanyId ( job.getCompanyId ( ) );
        jobRegistration.setRemarks ( "Pending" );
        jobRegistration.setPendingApplication ( false );
        jobRegistrationServiceRepo.save ( jobRegistration );
        return ResponseEntity.status ( HttpStatus.OK )
                .body ( new ResponseDTO ( true , HttpStatus.OK , "Application is Submitted Successfully!!" , "" ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > listOfApplicants ( ) {
        List < JobRegistration > jobRegistrations = jobRegistrationServiceRepo.findAll ( );
        List < ParticipantsListDTO > participantsListDTOS = jobRegistrations.stream ( ).map (
                jobRegistration -> {
                    Job job = jobServiceRepo.findById ( jobRegistration.getJobId ( ) ).get ( );
                    ParticipantsListDTO participantsListDTO = new ParticipantsListDTO ( );
                    participantsListDTO.setApplicant ( jobRegistration.getApplicant ( ) );
                    participantsListDTO.setJobTitle ( job.getOccupationTitle ( ) );
                    participantsListDTO.setAppliedDate ( jobRegistration.getRegistrationDate ( ) );
                    participantsListDTO.setStatus ( jobRegistration.getRemarks ( ) );
                    return participantsListDTO;
                }
        ).toList ( );

        return ResponseEntity.status ( HttpStatus.OK )
                .body ( new ResponseDTO ( true , HttpStatus.OK , "List of Applicants!!" , participantsListDTOS ) );

    }

    @Override
    public ResponseEntity < ResponseDTO > viewApplicant ( ParticularApplicationDTO particularApplicationDTO ) {


        JobRegistration jobRegistration = jobRegistrationServiceRepo.findByApplicantIdAndJobId ( particularApplicationDTO.getApplicantId ( ) , particularApplicationDTO.getJobId ( ) );
        if ( jobRegistration == null ) {
            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "There is No Application and Job!!" , "" ) );
        }
        Applicant applicant = applicantServiceRepo.findById ( jobRegistration.getApplicantId ( ) ).get ( );

        ParticularApplicationDTO particularApplicationDTO1 = new ParticularApplicationDTO ( );
        particularApplicationDTO1.setApplicantName ( jobRegistration.getApplicant ( ) );
        particularApplicationDTO1.setAddress ( applicant.getAddress ( ) );
        particularApplicationDTO1.setContactNo ( applicant.getContactNumber ( ) );
        particularApplicationDTO1.setEmail ( applicant.getEmailAddress ( ) );
        particularApplicationDTO1.setSex ( applicant.getSex ( ) );
        particularApplicationDTO1.setAge ( applicant.getAge ( ) );

        Job job = jobServiceRepo.findById ( particularApplicationDTO.getJobId ( ) ).get ( );
        particularApplicationDTO1.setOccupationTitle ( job.getOccupationTitle ( ) );
        particularApplicationDTO1.setCategory ( job.getCategory ( ) );
        particularApplicationDTO1.setReqNoEmployees ( job.getReqNoEmployees ( ) );
        particularApplicationDTO1.setSalaries ( job.getSalaries ( ) );
        particularApplicationDTO1.setDurationEmployment ( job.getDurationEmployment ( ) );
        particularApplicationDTO1.setQualificationWorkExperience ( job.getQualificationWorkExperience ( ) );
        particularApplicationDTO1.setJobDescription ( job.getJobDescription ( ) );
        particularApplicationDTO1.setPreferredSex ( job.getPreferredSex ( ) );
        particularApplicationDTO1.setSectorVacancy ( job.getSectorVacancy ( ) );
        particularApplicationDTO1.setStatus ( jobRegistration.getRemarks ( ) );

        return ResponseEntity.status ( HttpStatus.OK )
                .body ( new ResponseDTO ( true , HttpStatus.OK , "Detailed view of Particular Application.." , particularApplicationDTO1 ) );

    }

    @Override
    public ResponseEntity < ResponseDTO > feedBackImpl ( FeedBackDTO feedBackDTO ) {
        JobRegistration jobRegistration=jobRegistrationServiceRepo.findByApplicantIdAndJobId ( feedBackDTO.getApplicantId ( ),feedBackDTO.getJobId ()) ;
        if (jobRegistration == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDTO(false, HttpStatus.NOT_FOUND, "Application not found", ""));
        }
          if( jobRegistration.isPendingApplication ( ) )
          {
              return ResponseEntity.status ( HttpStatus.BAD_REQUEST )
                      .body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "Already Reviewed Your Application.." , "" ) );
          }
           jobRegistration.setPendingApplication ( true );
          jobRegistration.setRemarks ( feedBackDTO.getRemarks ( ) );
          jobRegistration.setDateTimeApproved ( new Timestamp ( System.currentTimeMillis () ) );
          jobRegistrationServiceRepo.save ( jobRegistration );

        return ResponseEntity.status ( HttpStatus.OK )
                .body ( new ResponseDTO ( true , HttpStatus.OK , "Reviewed Your Application!!" , "" ) );

    }

    @Override
    public ResponseEntity < ResponseDTO > appliedJobs (Long applicantId ) {
        Optional < Applicant > applicant=getApplicantOrThrowException ( applicantId );
        if(applicant.isEmpty ())
        {
           return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( false,HttpStatus.BAD_REQUEST,"There ia No Applicants for given Id: "+applicantId,"" ) );
        }
        List < JobRegistration > applicants=jobRegistrationServiceRepo.findByApplicantId(applicantId);
        if(applicants.isEmpty ())
        {
            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( false,HttpStatus.BAD_REQUEST,"Application Not Found!!","" ) );

        }
        List<AppliedJobsDTO> appliedJobs=applicants.stream( ).map (
                jobRegistration ->
                {
                    Job job=jobServiceRepo.findById ( jobRegistration.getJobId ( ) ).get ();
                    Company company=companyServiceRep.findById ( jobRegistration.getCompanyId ( ) ).get ();
                    AppliedJobsDTO appliedJobsDTO=new AppliedJobsDTO ();
                    appliedJobsDTO.setCompanyName ( company.getName ( ) );
                    appliedJobsDTO.setOccupationTittle ( job.getOccupationTitle () );
                    appliedJobsDTO.setAddress ( company.getAddress ( ) );
                    appliedJobsDTO.setStatus ( jobRegistration.getRemarks () );
                    appliedJobsDTO.setDateOfRemarks ( jobRegistration.getDateTimeApproved () );
                    return appliedJobsDTO;
                }
        ).collect( Collectors.toList());

        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true,HttpStatus.OK,"Applied Jobs!!",appliedJobs ) );
    }

    @Override
    public ResponseEntity<ResponseDTO> sendHtmlContent(Long applicantId) {
        Optional < Applicant > applicant = getApplicantOrThrowException ( applicantId );
        if ( applicant.isEmpty ( ) ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "There is No Applicant for the given Id: " + applicantId , "" ) );
        }
        List < JobRegistration > applicants = jobRegistrationServiceRepo.findByApplicantId ( applicantId );
        if ( applicants.isEmpty ( ) ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "Application Not Found!!" , "" ) );
        }
        String htmlContent = null;
        for ( JobRegistration jobRegistration : applicants ) {
            Job job = jobServiceRepo.findById ( jobRegistration.getJobId ( ) ).get ( );
            Company company = companyServiceRep.findById ( job.getCompanyId ( ) ).get ( );
            htmlContent = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Application Review Notification</title>\n" +
                    "</head>\n" +
                    "<body style=\"font-family: Arial, sans-serif; margin: 0; padding: 0;\">\n" +
                    "\n" +
                    "<div style=\"max-width: 600px; margin: 20px auto; padding: 20px; background-color: #f7f7f7; border-radius: 10px;\">\n" +
                    "    <h2 style=\"color: #333333;\">Application Review Notification</h2>\n" +
                    "    <p>Dear " + applicant.get().getFirstName() + ",</p>\n" +
                    "\n" +
                    "    <p>We hope this email finds you well.</p>\n" +
                    "\n" +
                    "    <p>We wanted to inform you that we have reviewed your application for the position of " + job.getOccupationTitle() + ". We appreciate the time and effort you put into your application.</p>\n" +
                    "\n" +
                    "    <p>We genuinely appreciate your interest in joining our team and encourage you to keep an eye on our career page for future opportunities that match your skills and experience.</p>\n" +
                    "\n" +
                    "    <p>Thank you again for your interest in " + company.getName() + ".</p>\n" +
                    "\n" +
                    "    <p>Best regards,</p>\n" +
                    "    " + company.getName() + "<br>\n" +
                    "    " + company.getContactNumber() + "</p>\n" +
                    "</div>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>";
            break;
        }
        return ResponseEntity.ok ( ).body ( new ResponseDTO ( true , HttpStatus.OK , "Messages Delivered successfully" , htmlContent ) );
    }


    private Optional < Applicant > getApplicantOrThrowException ( long applicantId ) {
        return applicantServiceRepo.findById ( applicantId );
    }

}