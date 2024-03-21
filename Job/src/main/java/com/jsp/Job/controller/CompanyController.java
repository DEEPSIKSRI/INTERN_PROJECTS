package com.jsp.Job.controller;

import com.jsp.Job.api.CompanyApi;
import com.jsp.Job.dto.CompanyDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Company;
import com.jsp.Job.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyController implements CompanyApi {

    private final CompanyService companyService;

    @Override
    public ResponseEntity < ResponseDTO > particularCompany ( Integer companyId ) {
        return companyService.getParticularCompany(companyId);
    }

    @Override
    public ResponseEntity< ResponseDTO> getAllCompany ( ) {
        return companyService.listOfCompanies();
    }

    @Override
    public ResponseEntity < ResponseDTO > addCompany ( CompanyDTO companyDTO ) {
        return companyService.addCompany(companyDTO);
    }

    @Override
    public ResponseEntity < ResponseDTO > updateCompany ( CompanyDTO companyDTO ) {
        return companyService.updateCompany(companyDTO);
    }

    @Override
    public ResponseEntity < ResponseDTO > deleteCompany ( Integer companyId ) {
        return companyService.deleteCompany(companyId);
    }

    @Override
    public ResponseEntity < ResponseDTO > deleteAllCompany ( ) {
        return companyService.deleteAllCompany();
    }

    @Override
    public ResponseEntity < ResponseDTO > listOfCompanyName ( ) {
        return companyService.listOfCompaniesName();
    }

    @Override
    public ResponseEntity < ResponseDTO > searchByCompanyName ( String companyName ) {
        return companyService.searchByName(companyName);
    }
}