package com.jsp.Job.service;

import com.jsp.Job.dto.CompanyDTO;
import com.jsp.Job.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {
   ResponseEntity< ResponseDTO > listOfCompanies ( );

   ResponseEntity< ResponseDTO> addCompany ( CompanyDTO companyDTO );

    ResponseEntity< ResponseDTO> updateCompany ( CompanyDTO companyDTO );

    ResponseEntity< ResponseDTO> getParticularCompany ( Integer companyId );

    ResponseEntity< ResponseDTO> deleteCompany ( Integer companyId );

    ResponseEntity< ResponseDTO> deleteAllCompany ( );

    ResponseEntity< ResponseDTO> listOfCompaniesName ( );

    ResponseEntity< ResponseDTO> searchByName ( String companyName );
}