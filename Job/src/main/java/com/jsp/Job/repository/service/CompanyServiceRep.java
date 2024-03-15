package com.jsp.Job.repository.service;

import com.jsp.Job.dto.CompanyDTO;
import com.jsp.Job.entity.Company;

import java.util.List;

public interface CompanyServiceRep {

    List< Company > findAll();

    boolean existsCompanyByName( String name);

    Company save ( Company company );
}