package com.jsp.Job.service.Impl;

import com.jsp.Job.dto.CompanyDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Company;
import com.jsp.Job.repository.service.CompanyServiceRep;
import com.jsp.Job.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyServiceRep companyServiceRep;

    @Override
    public ResponseEntity < ResponseDTO > listOfCompanies ( ) {

        List < Company > companies = companyServiceRep.findAll ( );
        CompanyDTO companyDTO = new CompanyDTO ( );
        for ( Company company : companies ) {

            companyDTO.setName ( company.getName ( ) );
            companyDTO.setAddress ( company.getAddress ( ) );
            companyDTO.setContactNumber ( company.getContactNumber ( ) );
        }
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "List of Companies!!" , companyDTO ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > addCompany ( CompanyDTO companyDTO ) {
        Company company=new Company ();
        if(companyServiceRep.existsCompanyByName ( companyDTO.getName ( ) ))
        {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "Company is Already Exist!!" , companyDTO.getName () ) );
        }
        company.setName ( companyDTO.getName ( ) );
        company.setAddress ( companyDTO.getAddress ( ) );
        company.setContactNumber ( companyDTO.getContactNumber ( ) );
        companyServiceRep.save(company);
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Added Company!!" , company ) );
    }
}