package com.jsp.Job.repository.service;

import com.jsp.Job.entity.Job;

import java.util.List;
import java.util.Optional;

public interface
JobServiceRepo {
    Optional < Job > findById ( Long jobId );

    Job save ( Job job );

    List<Job> findAll ( );

    List<Job> findByCompanyId(Integer companyId);
    boolean existsByOccupationTitle(String occupationTittle);

    List<Job> findByOccupationTitle( String occupationTitle );

    List<Job> findByCategory( String category );

    List<Job> findByCompanyIdAndOccupationTitle( Integer companyId , String occupationTitle ) ;

    List<String> findAllByOccupationTitle();

}