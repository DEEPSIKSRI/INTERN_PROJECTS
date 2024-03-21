package com.jsp.Job.serviceTest;

import com.jsp.Job.dto.ResponseDTO;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ApplicantServiceTest {
    @BeforeEach
    void setUp ( ) {
        MockitoAnnotations.openMocks ( this );
    }

    @InjectMocks
    ApplicantServiceImpl applicantService;

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
        when ( companyService.listOfCompanies ( ) ).thenReturn ( response );

        ResponseEntity < ResponseDTO > actual = applicantService.fetchAll ( );
        assertEquals ( response , actual );
    }
}