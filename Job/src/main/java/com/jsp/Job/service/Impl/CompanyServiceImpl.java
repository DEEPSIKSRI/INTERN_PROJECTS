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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyServiceRep companyServiceRep;

    @Override
    public ResponseEntity < ResponseDTO > listOfCompanies ( ) {

        List < Company > companies = companyServiceRep.findAll ( );
        List < CompanyDTO > companyDTOs = companies.stream ( )
                .map ( company -> {
                    CompanyDTO dto = new CompanyDTO ( );
                    dto.setName ( company.getName ( ) );
                    dto.setAddress ( company.getAddress ( ) );
                    dto.setContactNumber ( company.getContactNumber ( ) );
                    return dto;
                } )
                .collect ( Collectors.toList ( ) );
        return ResponseEntity
                .status ( HttpStatus.OK )
                .body ( new ResponseDTO ( true , HttpStatus.OK , "List of Companies" , companyDTOs ) );
    }


    @Override
    public ResponseEntity < ResponseDTO > addCompany ( CompanyDTO companyDTO ) {
        Company company = new Company ( );
        if ( companyServiceRep.existsCompanyByName ( companyDTO.getName ( ) ) ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "Company is Already Exist!!" , companyDTO.getName ( ) ) );
        }
        company.setCompanyId ( companyDTO.getCompanyId ( ) );
        company.setName ( companyDTO.getName ( ) );
        company.setAddress ( companyDTO.getAddress ( ) );
        company.setContactNumber ( companyDTO.getContactNumber ( ) );
        companyServiceRep.save ( company );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Added Company!!" , company ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > updateCompany ( CompanyDTO companyDTO ) {
        Company company = companyOrElseThrowException ( companyDTO.getCompanyId ( ) );
        if ( company == null ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "Company is not found" , "" ) );
        }
        company.setName ( companyDTO.getName ( ) );
        company.setAddress ( companyDTO.getAddress ( ) );
        company.setContactNumber ( companyDTO.getContactNumber ( ) );
        companyServiceRep.save ( company );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Updated Company " , "" ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > getParticularCompany ( Integer companyId ) {
        Company company = companyOrElseThrowException ( companyId );
        if ( company == null ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "Company is not found" , "" ) );
        }
        CompanyDTO companyDTO = new CompanyDTO ( );
        companyDTO.setName ( company.getName ( ) );
        companyDTO.setAddress ( company.getAddress ( ) );
        companyDTO.setContactNumber ( company.getContactNumber ( ) );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Retrieved Particular Company!! " , companyDTO ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > deleteCompany ( Integer companyId ) {
        Company company = companyOrElseThrowException ( companyId );
        if ( company == null ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "Company is not found" , "" ) );
        }
        companyServiceRep.deleteById ( companyId );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Company is Deleted!!" , "" ) );

    }

    @Override
    public ResponseEntity < ResponseDTO > deleteAllCompany ( ) {
        companyServiceRep.deleteAll ( );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "All Company is Deleted!!" , "" ) );

    }

    @Override
    public ResponseEntity < ResponseDTO > listOfCompaniesName ( ) {
        List < String > companyByName = companyServiceRep.findAllByCompanyName ( );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Retrieved All CompanyName" , companyByName ) );

    }

    @Override
    public ResponseEntity < ResponseDTO > searchByName ( String companyName ) {
        boolean companyNameList = companyServiceRep.existsCompanyByName ( companyName );
        if ( !companyNameList ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "Company Not Found Based on your Search!!" , "" ) );
        }
        Company company = companyServiceRep.findCompanyByName ( companyName );
        CompanyDTO companyDTO = new CompanyDTO ( );
        companyDTO.setName ( company.getName ( ) );
        companyDTO.setContactNumber ( company.getContactNumber ( ) );
        companyDTO.setAddress ( company.getAddress ( ) );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Retrieved Company By Name" , companyDTO ) );

    }

    private Company companyOrElseThrowException ( int companyId ) {
        return companyServiceRep.findById ( companyId ).orElse ( null );
    }
}