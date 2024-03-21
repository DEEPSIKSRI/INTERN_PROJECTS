package com.jsp.Job.repository.service.Impl;

import com.jsp.Job.entity.Applicant;
import com.jsp.Job.entity.JobRegistration;
import com.jsp.Job.repository.ApplicantRepository;
import com.jsp.Job.repository.service.ApplicantServiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicantRepoServiceImpl implements ApplicantServiceRepo {

    public final ApplicantRepository applicantRepository;
    @Override
    public Optional < Applicant > findById ( long applicantId ) {
        return applicantRepository.findById ( applicantId );
    }

    @Override
    public void save ( Applicant applicant ) {
      applicantRepository.save ( applicant );
    }

    @Override
    public boolean existsApplicantByApplicantId ( long applicantId ) {
        return applicantRepository.existsApplicantByApplicantId ( applicantId );
    }

    @Override
    public List < Applicant > findAll ( ) {
        return applicantRepository.findAll (  );
    }


}