package com.jsp.Job.api;

import com.jsp.Job.dto.CompanyDTO;
import com.jsp.Job.dto.ResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/company")
@RestController
public interface CompanyApi {

    @PreAuthorize( "hasAnyRole('ADMIN','USER')" )
    @GetMapping("/particularCompany/{companyId}")
    ResponseEntity<ResponseDTO> particularCompany(@PathVariable Integer companyId);

    @PreAuthorize( "hasAnyRole('ADMIN','USER')" )
    @GetMapping("/listOfCompany")
    ResponseEntity< ResponseDTO> getAllCompany();

    @PreAuthorize( "hasAnyRole('ADMIN')" )
    @PostMapping("/addCompany")
    ResponseEntity<ResponseDTO> addCompany(@Valid  @RequestBody CompanyDTO companyDTO );

    @PreAuthorize( "hasAnyRole('ADMIN')" )
    @PutMapping("/UpdateCompanies")
     ResponseEntity<ResponseDTO> updateCompany(@Valid  @RequestBody CompanyDTO companyDTO);

    @PreAuthorize( "hasAnyRole('ADMIN')" )
    @DeleteMapping("/deleteCompany/{companyId}")
    ResponseEntity<ResponseDTO> deleteCompany(@PathVariable Integer companyId);

    @PreAuthorize( "hasAnyRole('ADMIN')" )
    @DeleteMapping("/deleteAllCompany")
    ResponseEntity<ResponseDTO> deleteAllCompany();

    @PreAuthorize( "hasAnyRole('ADMIN','USER')" )
    @GetMapping("/listOfCompanyByName")
    ResponseEntity<ResponseDTO>  listOfCompanyName();

    @PreAuthorize( "hasAnyRole('ADMIN','USER')" )
    @GetMapping("/searchByCompanyName/{companyName}")
    ResponseEntity<ResponseDTO> searchByCompanyName(@PathVariable String companyName);

}