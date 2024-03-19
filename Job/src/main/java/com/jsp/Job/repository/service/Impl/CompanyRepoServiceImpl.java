package com.jsp.Job.repository.service.Impl;

import com.jsp.Job.entity.Company;
import com.jsp.Job.repository.CompanyRepository;
import com.jsp.Job.repository.service.CompanyServiceRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Company companyId ( Integer companyId ) {
        return companyRepository.findByCompanyId ( companyId );
    }

    @Override
    public Optional < Company > findById ( Integer companyId ) {
        return companyRepository.findById ( companyId );
    }

    @Override
    public void deleteById ( Integer companyId ) {
         companyRepository.deleteById ( companyId );
    }

    @Override
    public void deleteAll ( ) {
        companyRepository.findAll (  );
    }

    @Override
    public List<String> findAllByCompanyName ( ) {
        return companyRepository.findAllByCompanyName ();
    }

    @Override
    public Company findCompanyByName ( String companyName ) {
        return companyRepository.findCompanyByName ( companyName );
    }
}