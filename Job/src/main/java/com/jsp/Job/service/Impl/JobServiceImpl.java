package com.jsp.Job.service.Impl;

import com.jsp.Job.dto.JobTitleDescriptionDTO;
import com.jsp.Job.dto.JobVacancyDTO;
import com.jsp.Job.dto.JobVacancyDetailsDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Category;
import com.jsp.Job.entity.Company;
import com.jsp.Job.entity.Job;
import com.jsp.Job.repository.ApplicantRepository;
import com.jsp.Job.repository.service.CategoryServiceRepo;
import com.jsp.Job.repository.service.CompanyServiceRep;
import com.jsp.Job.repository.service.JobRegistrationServiceRepo;
import com.jsp.Job.repository.service.JobServiceRepo;
import com.jsp.Job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final CompanyServiceRep companyServiceRep;
    private final CategoryServiceRepo categoryServiceRepo;
    private final JobServiceRepo jobServiceRepo;
    private final JobRegistrationServiceRepo jobRegistrationServiceRepo;
    private final ApplicantRepository applicantRepository;

    @Override
    public ResponseEntity < ResponseDTO > addNewJobVacancy ( JobVacancyDTO jobVacancyDTO ) {
        Long category = categoryServiceRepo.findByCategory ( jobVacancyDTO.getCategory ( ) );
        Category category1 = categoryServiceRepo.findById ( category ).get ( );
        Optional < Company > company = companyServiceRep.findById ( jobVacancyDTO.getCompanyId ( ) );

        Job job = new Job ( );
        job.setCategory ( category1.getCategory ( ) );
        job.setCompanyId ( company.get ( ).getCompanyId ( ) );
        job.setJobDescription ( jobVacancyDTO.getJobDescription ( ) );
        job.setDurationEmployment ( jobVacancyDTO.getDurationEmployment ( ) );
        job.setOccupationTitle ( jobVacancyDTO.getOccupationTitle ( ) );
        job.setPreferredSex ( jobVacancyDTO.getPreferredSex ( ) );
        job.setQualificationWorkExperience ( jobVacancyDTO.getQualificationWorkExperience ( ) );
        job.setSalaries ( jobVacancyDTO.getSalaries ( ) );
        job.setReqNoEmployees ( jobVacancyDTO.getReqNoEmployees ( ) );
        job.setSectorVacancy ( jobVacancyDTO.getSectorVacancy ( ) );
        jobServiceRepo.save ( job );

        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Added New Job Vacancy!!" , "" ) );
    }


    @Override
    public ResponseEntity < ResponseDTO > saveJob ( Job job ) {
        jobServiceRepo.save ( job );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Added Job!!" , "" ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > listOfJobVacancy ( ) {
        List < Job > job = jobServiceRepo.findAll ( );
        List < JobVacancyDTO > jobVacancyDTOS = job.stream ( ).map ( job1 ->
        {
            JobVacancyDTO jobVacancyDTO = new JobVacancyDTO ( );
            jobVacancyDTO.setCompanyId ( job1.getCompanyId ( ) );
            jobVacancyDTO.setJobDescription ( job1.getJobDescription ( ) );
            jobVacancyDTO.setSectorVacancy ( job1.getSectorVacancy ( ) );
            jobVacancyDTO.setSalaries ( job1.getSalaries ( ) );
            jobVacancyDTO.setDurationEmployment ( job1.getDurationEmployment ( ) );
            jobVacancyDTO.setOccupationTitle ( job1.getOccupationTitle ( ) );
            jobVacancyDTO.setPreferredSex ( job1.getPreferredSex ( ) );
            jobVacancyDTO.setQualificationWorkExperience ( job1.getQualificationWorkExperience ( ) );
            jobVacancyDTO.setReqNoEmployees ( job1.getReqNoEmployees ( ) );
            jobVacancyDTO.setStatus ( job1.getJobStatus ( ) );
            return jobVacancyDTO;
        } ).toList ( );

        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "List of Job Vacancy Details!!" , jobVacancyDTOS ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > particularCompany ( String companyName ) {
        if ( !companyServiceRep.existsCompanyByName ( companyName ) ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "No Hiring in this Company!!" , "" ) );
        }
        Company company = companyServiceRep.findCompanyByName ( companyName );
        List < Job > jobs = jobServiceRepo.findByCompanyId ( company.getCompanyId ( ) );
        List < JobVacancyDetailsDTO > jobVacancyDetailsDTOS = jobs.stream ( ).map ( job -> {
            JobVacancyDetailsDTO jobVacancyDetailsDTO = new JobVacancyDetailsDTO ( );
            jobVacancyDetailsDTO.setName ( company.getName ( ) );
            jobVacancyDetailsDTO.setAddress ( company.getAddress ( ) );
            jobVacancyDetailsDTO.setOccupationTitle ( job.getOccupationTitle ( ) );
            jobVacancyDetailsDTO.setDatePosted ( job.getDatePosted ( ) );
            return jobVacancyDetailsDTO;
        } ).toList ( );

        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Hiring process is ongoing in " + companyName + " company." , jobVacancyDetailsDTOS ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > searchCompanyByTitle ( String occupationTittle ) {
        if ( !jobServiceRepo.existsByOccupationTitle ( occupationTittle ) ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "No Hiring in this OccupationTitle!!" , "" ) );
        }
        List < Job > jobs = jobServiceRepo.findByOccupationTitle ( occupationTittle );
        List < JobTitleDescriptionDTO > jobTitleDescriptionDTOS = jobs.stream ( ).map (
                job -> {
                    JobTitleDescriptionDTO jobTitleDescriptionDTO = new JobTitleDescriptionDTO ( );
                    jobTitleDescriptionDTO.setOccupationTitle ( job.getOccupationTitle ( ) );
                    jobTitleDescriptionDTO.setJobDescription ( job.getJobDescription ( ) );
                    return jobTitleDescriptionDTO;
                }
        ).toList ( );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Hiring process is ongoing for the occupation of " + occupationTittle + "." , jobTitleDescriptionDTOS ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > searchByCategory ( String category ) {
        if ( jobServiceRepo.findByCategory ( category ).isEmpty ( ) ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "No Hiring in this Category!!" , "" ) );
        }
        List < Job > jobs = jobServiceRepo.findByCategory ( category );
        List < JobTitleDescriptionDTO > jobTitleDescriptionDTOS = jobs.stream ( ).map (
                job -> {
                    JobTitleDescriptionDTO jobTitleDescriptionDTO = new JobTitleDescriptionDTO ( );
                    jobTitleDescriptionDTO.setOccupationTitle ( job.getOccupationTitle ( ) );
                    jobTitleDescriptionDTO.setJobDescription ( job.getJobDescription ( ) );
                    return jobTitleDescriptionDTO;
                }
        ).toList ( );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Hiring process is ongoing for the Category of " + category + "." , jobTitleDescriptionDTOS ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > searchByNameAndTitle ( JobVacancyDTO jobVacancyDTO1 ) {
        List < Job > job = jobServiceRepo.findByCompanyIdAndOccupationTitle ( jobVacancyDTO1.getCompanyId ( ) , jobVacancyDTO1.getOccupationTitle ( ) );
        if ( job.isEmpty ( ) ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "No Hiring in this Company and OccupationTitle!!" , "" ) );
        }
        List < JobVacancyDTO > jobVacancyDTOS = job.stream ( ).map (
                job1 -> {
                    JobVacancyDTO jobVacancyDTO = new JobVacancyDTO ( );
                    jobVacancyDTO.setCompanyId ( job1.getCompanyId ( ) );
                    jobVacancyDTO.setJobId ( job1.getJobId ( ) );
                    jobVacancyDTO.setCategory ( job1.getCategory ( ) );
                    jobVacancyDTO.setJobDescription ( job1.getJobDescription ( ) );
                    jobVacancyDTO.setSectorVacancy ( job1.getSectorVacancy ( ) );
                    jobVacancyDTO.setSalaries ( job1.getSalaries ( ) );
                    jobVacancyDTO.setDurationEmployment ( job1.getDurationEmployment ( ) );
                    jobVacancyDTO.setOccupationTitle ( job1.getOccupationTitle ( ) );
                    jobVacancyDTO.setPreferredSex ( job1.getPreferredSex ( ) );
                    jobVacancyDTO.setQualificationWorkExperience ( job1.getQualificationWorkExperience ( ) );
                    jobVacancyDTO.setReqNoEmployees ( job1.getReqNoEmployees ( ) );
                    return jobVacancyDTO;
                } ).toList ( );


        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Details of Particular Job by Title and Company" , jobVacancyDTOS ) );

    }

    @Override
    public ResponseEntity < ResponseDTO > listOfJobByTittle ( ) {
        List < String > list = jobServiceRepo.findAllByOccupationTitle ( );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "List of OccupationTitle" , list ) );
    }


}