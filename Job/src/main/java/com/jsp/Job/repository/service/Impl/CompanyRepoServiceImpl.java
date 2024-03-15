package com.jsp.Job.repository.service.Impl;

import com.jsp.Job.dto.CompanyDTO;
import com.jsp.Job.entity.Company;
import com.jsp.Job.repository.CompanyRepository;
import com.jsp.Job.repository.service.CompanyServiceRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyRepoServiceImpl implements CompanyServiceRep {

    private final CompanyRepository companyRepository;
    @Override
    public List < Company > findAll ( ) {
        return companyRepository.findAll ();
    }

    @Override
    public boolean existsCompanyByName ( String name ) {
        return companyRepository.existsCompanyByName ( name );
    }

    @Override
    public Company save ( Company company ) {
        return companyRepository.save ( company );
    }
}