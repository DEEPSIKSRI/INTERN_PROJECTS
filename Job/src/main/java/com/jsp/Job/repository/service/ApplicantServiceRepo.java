package com.jsp.Job.repository.service;

import com.jsp.Job.entity.Applicant;
import com.jsp.Job.entity.JobRegistration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ApplicantServiceRepo{

    Optional< Applicant > findById ( long applicantId );

    void save(Applicant applicant);

    boolean existsApplicantByApplicantId( long applicantId )  ;

    List< Applicant> findAll ( );
}