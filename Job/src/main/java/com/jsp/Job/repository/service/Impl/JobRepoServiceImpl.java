package com.jsp.Job.repository.service.Impl;


import com.jsp.Job.entity.Job;
import com.jsp.Job.repository.JobRepository;
import com.jsp.Job.repository.service.JobServiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobRepoServiceImpl implements JobServiceRepo {

    private final JobRepository jobRepository;

    @Override
    public Optional < Job > findById ( Long jobId ) {
       return jobRepository.findById ( jobId );

    }


    @Override
    public Job save ( Job job ) {
       return jobRepository.save ( job );

    }

    @Override
    public List <Job> findAll ( ) {
        return jobRepository.findAll ();
    }

    @Override
    public List<Job> findByCompanyId ( Integer companyId ) {
       return jobRepository.findByCompanyId ( companyId );
    }

    @Override
    public boolean existsByOccupationTitle ( String occupationTittle ) {
        return jobRepository.existsByOccupationTitle ( occupationTittle );
    }

    @Override
    public List < Job > findByOccupationTitle ( String occupationTitle ) {
        return jobRepository.findByOccupationTitle ( occupationTitle );
    }

    @Override
    public List < Job > findByCategory ( String category ) {
        return jobRepository.findByCategory ( category );
    }

    @Override
    public List < Job > findByCompanyIdAndOccupationTitle ( Integer companyId , String occupationTitle ) {
        return jobRepository.findByCompanyIdAndOccupationTitle ( companyId, occupationTitle );
    }

    @Override
    public List < String > findAllByOccupationTitle ( ) {
        return jobRepository.findAllByOccupationTitle ();
    }


}