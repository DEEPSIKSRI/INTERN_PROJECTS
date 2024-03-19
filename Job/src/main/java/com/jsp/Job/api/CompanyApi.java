package com.jsp.Job.api;

import com.jsp.Job.dto.CompanyDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Company;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company")
@RestController
public interface CompanyApi {

    @GetMapping("/particularCompany/{companyId}")
    ResponseEntity<ResponseDTO> particularCompany(@PathVariable Integer companyId);

    @GetMapping("/listOfCompany")
    ResponseEntity< ResponseDTO> getAllCompany();

    @PostMapping("/addCompany")
    ResponseEntity<ResponseDTO> addCompany(@Valid  @RequestBody CompanyDTO companyDTO );

    @PutMapping("/UpdateCompanies")
     ResponseEntity<ResponseDTO> updateCompany(@Valid  @RequestBody CompanyDTO companyDTO);

    @DeleteMapping("/deleteCompany/{companyId}")
    ResponseEntity<ResponseDTO> deleteCompany(@PathVariable Integer companyId);

    @DeleteMapping("/deleteAllCompany")
    ResponseEntity<ResponseDTO> deleteAllCompany();

    @GetMapping("/listOfCompanyByName")
    ResponseEntity<ResponseDTO>  listOfCompanyName();

    @GetMapping("/searchByCompanyName/{companyName}")
    ResponseEntity<ResponseDTO> searchByCompanyName(@PathVariable String companyName);

}