package com.jsp.Job.repository.service.Impl;

import com.jsp.Job.entity.JobRegistration;
import com.jsp.Job.repository.JobRegistrationRepository;
import com.jsp.Job.repository.service.JobRegistrationServiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobRegistrationRepoServiceImpl implements JobRegistrationServiceRepo {
    private final JobRegistrationRepository jobRegistrationRepository;
    @Override
    public void save ( JobRegistration jobRegistration ) {
         jobRegistrationRepository.save ( jobRegistration );
    }

    @Override
    public JobRegistration findByApplicantIdAndJobId ( long applicantId , long jobId ) {
        return jobRegistrationRepository.findByApplicantIdAndJobId ( applicantId, jobId );
    }

    @Override
    public boolean existsByApplicantIdAndJobId ( Long applicantId , Long jobId ) {
        return jobRegistrationRepository.existsByApplicantIdAndJobId(  applicantId ,  jobId  );
    }

    @Override
    public List < JobRegistration > findAll ( ) {
        return jobRegistrationRepository.findAll (  );
    }

    @Override
    public JobRegistration findByApplicantIdAndJobIdAndCompanyId ( Long applicantId , Long jobId , Integer companyId ) {
        return jobRegistrationRepository.findByApplicantIdAndJobIdAndCompanyId ( applicantId, jobId, companyId );
    }

    @Override
    public List < JobRegistration > findByApplicantId ( Long applicantId ) {
        return jobRegistrationRepository.findByApplicantId( applicantId );
    }
}