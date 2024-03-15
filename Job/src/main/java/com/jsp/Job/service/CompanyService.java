package com.jsp.Job.service;

import com.jsp.Job.dto.CompanyDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
   ResponseEntity< ResponseDTO > listOfCompanies ( );

   ResponseEntity< ResponseDTO> addCompany ( CompanyDTO companyDTO );
}