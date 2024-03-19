package com.jsp.Job.service;

import com.jsp.Job.dto.AddEmployeeDTO;
import com.jsp.Job.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    ResponseEntity < ResponseDTO > listOfAllEmployees ( );

    ResponseEntity< ResponseDTO> saveEmployee ( AddEmployeeDTO addEmployeeDTO );
}