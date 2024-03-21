package com.jsp.Job.repository;

import com.jsp.Job.entity.JobRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRegistrationRepository extends JpaRepository< JobRegistration,Long > {
     JobRegistration findByApplicantIdAndJobId ( long applicantId , long jobId );

    boolean existsByApplicantIdAndJobId( Long applicantId , Long jobId  );

    JobRegistration findByApplicantIdAndJobIdAndCompanyId( Long applicantId , Long jobId , Integer companyId );

    List< JobRegistration> findByApplicantId ( Long applicantId );
}