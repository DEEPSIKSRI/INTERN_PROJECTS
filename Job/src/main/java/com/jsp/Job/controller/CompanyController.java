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
    public ResponseEntity< ResponseDTO> getAllCompany ( ) {
        return companyService.listOfCompanies();
    }

    @Override
    public ResponseEntity < ResponseDTO > addCompany ( CompanyDTO companyDTO ) {
        return companyService.addCompany(companyDTO);
    }
}