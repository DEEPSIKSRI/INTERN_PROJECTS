package com.jsp.Job.api;

import com.jsp.Job.dto.CompanyDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company")
@RestController
public interface CompanyApi {

    @GetMapping("/listOfCompany")
    ResponseEntity< ResponseDTO> getAllCompany();

    @PostMapping("/addCompany")
    ResponseEntity<ResponseDTO> addCompany( @RequestBody CompanyDTO companyDTO );
}