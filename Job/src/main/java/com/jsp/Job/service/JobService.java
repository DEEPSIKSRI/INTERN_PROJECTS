package com.jsp.Job.service;

import com.jsp.Job.dto.JobVacancyDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Job;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface JobService {
    ResponseEntity < ResponseDTO > addNewJobVacancy ( JobVacancyDTO jobVacancyDTO );

    ResponseEntity < ResponseDTO > saveJob ( Job job );

    ResponseEntity < ResponseDTO > listOfJobVacancy ( );

    ResponseEntity < ResponseDTO > particularCompany ( String companyName );

    ResponseEntity < ResponseDTO > searchCompanyByTitle ( String occupationTittle );

    ResponseEntity < ResponseDTO > searchByCategory ( String category );

    ResponseEntity < ResponseDTO > searchByNameAndTitle ( JobVacancyDTO jobVacancyDTO );


    ResponseEntity < ResponseDTO > listOfJobByTittle ( );
}