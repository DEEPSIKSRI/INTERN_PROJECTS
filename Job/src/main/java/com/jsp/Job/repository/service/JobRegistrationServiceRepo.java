package com.jsp.Job.repository.service;

import com.jsp.Job.entity.JobRegistration;

import java.util.List;
import java.util.Optional;

public interface JobRegistrationServiceRepo {
    void save ( JobRegistration jobRegistration );

   JobRegistration findByApplicantIdAndJobId ( long applicantId , long jobId );

    boolean existsByApplicantIdAndJobId( Long applicantId , Long jobId  );

    List< JobRegistration> findAll ( );

    JobRegistration findByApplicantIdAndJobIdAndCompanyId(Long applicantId,Long jobId,Integer companyId);

    List< JobRegistration> findByApplicantId ( Long applicantId );
}