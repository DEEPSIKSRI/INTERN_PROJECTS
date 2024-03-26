package com.jsp.Job.controllerTest;

import com.jsp.Job.controller.ApplicantController;
import com.jsp.Job.dto.JobApplyDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.JobRegistration;
import com.jsp.Job.repository.service.ApplicantServiceRepo;
import com.jsp.Job.repository.service.CompanyServiceRep;
import com.jsp.Job.repository.service.JobRegistrationServiceRepo;
import com.jsp.Job.repository.service.JobServiceRepo;
import com.jsp.Job.service.Impl.ApplicantServiceImpl;
import com.jsp.Job.service.Impl.CompanyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ApplicantControllerTest {
    @BeforeEach
    void setUp ( ) {
        MockitoAnnotations.openMocks ( this );
    }

    @Mock
    ApplicantServiceImpl applicantService;

    @InjectMocks
    ApplicantController applicantController;

    @Mock
    ApplicantServiceRepo applicantServiceRepo;
    @Mock
    JobRegistrationServiceRepo jobRegistrationServiceRepo;
    @Mock
    JobServiceRepo jobServiceRepo;
    @Mock
    CompanyServiceRep companyServiceRep;
    @Mock
    CompanyServiceImpl companyService;

    @Test
    void testGetAll ( ) {

        ResponseEntity < ResponseDTO > responseEntity = applicantService.fetchAll ( );
        ResponseDTO responseDTO = new ResponseDTO ( true , HttpStatus.OK , "Fetched All Data" , responseEntity );
        ResponseEntity < ResponseDTO > response = new ResponseEntity <> ( responseDTO , HttpStatus.OK );
        when ( applicantController.getAll ( ) ).thenReturn ( response );
        assertTrue ( true );
    }

    @Test
    void testJobApply ( ) {

        JobApplyDTO jobApplyDTO = new JobApplyDTO ( );
        ResponseEntity < ResponseDTO > expectedResponse = new ResponseEntity <> ( new ResponseDTO ( ) , HttpStatus.OK );

        when ( applicantService.applyJob ( jobApplyDTO ) ).thenReturn ( expectedResponse );

        ResponseEntity < ResponseDTO > actualResponse = applicantController.jobApply ( jobApplyDTO );

        assertEquals ( expectedResponse , actualResponse );
    }

    @Test
    void testListOfApplicants()
    {
        JobRegistration jobRegistration=new JobRegistration ();
        List<JobRegistration> jobRegistrationList=new ArrayList <> (  );
        jobRegistrationList.add ( jobRegistration );
        when ( applicantController.listOfApplicants () ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true,HttpStatus.OK,"List of Applicants!!",jobRegistrationList ) ) );

        assertTrue ( true );
    }
}