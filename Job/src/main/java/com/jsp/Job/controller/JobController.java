package com.jsp.Job.controller;

import com.jsp.Job.api.JobApi;
import com.jsp.Job.dto.JobApplyDTO;
import com.jsp.Job.dto.JobVacancyDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Job;
import com.jsp.Job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JobController implements JobApi {

    private final JobService jobService;

    @Override
    public ResponseEntity < ResponseDTO > saveJobVacancy ( Job job ) {
        return jobService.saveJob(job);
    }

    @Override
    public ResponseEntity < ResponseDTO > jobVacancy ( JobVacancyDTO jobVacancyDTO ) {
        return jobService.addNewJobVacancy(jobVacancyDTO);
    }

    @Override
    public ResponseEntity < ResponseDTO > listOfJobVacancy ( ) {
        return jobService.listOfJobVacancy();
    }

    @Override
    public ResponseEntity < ResponseDTO > listOfJobByTittle ( ) {
        return jobService.listOfJobByTittle();
    }

    @Override
    public ResponseEntity < ResponseDTO > particularCompany ( String companyName ) {
        return jobService.particularCompany(companyName);
    }

    @Override
    public ResponseEntity < ResponseDTO > searchByTitle ( String occupationTittle ) {
        return jobService.searchCompanyByTitle(occupationTittle);
    }

    @Override
    public ResponseEntity < ResponseDTO > searchByCategory ( String category ) {
        return jobService.searchByCategory(category);
    }

    @Override
    public ResponseEntity < ResponseDTO > searchByCompanyNameAndTitle ( JobVacancyDTO jobVacancyDTO ) {
        return jobService.searchByNameAndTitle(jobVacancyDTO);
    }


}