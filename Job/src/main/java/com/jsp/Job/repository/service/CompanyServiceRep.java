package com.jsp.Job.repository.service;

import com.jsp.Job.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyServiceRep {

    List< Company > findAll();

    boolean existsCompanyByName( String name);

    Company save ( Company company );

    Company companyId(Integer companyId);

    Optional < Company > findById( Integer companyId);

    void deleteById ( Integer companyId );

    void deleteAll ( );

    List<String> findAllByCompanyName( );
    Company findCompanyByName(String companyName);
}