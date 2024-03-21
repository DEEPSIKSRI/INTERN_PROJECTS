package com.jsp.Job.api;

import com.jsp.Job.dto.AddEmployeeDTO;
import com.jsp.Job.dto.ResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employee")
@RestController
public interface EmployeeApi {

    @PreAuthorize( "hasAnyRole('ADMIN')" )
    @GetMapping("/listOfEmployees")
    ResponseEntity < ResponseDTO > listOfEmployees ( );

    @PreAuthorize( "hasAnyRole('ADMIN','USER')" )
    @PostMapping("/addEmployee")
    ResponseEntity<ResponseDTO> addEmployee( @Valid @RequestBody AddEmployeeDTO addEmployeeDTO );
}