package com.jsp.Job.controller;

import com.jsp.Job.api.EmployeeApi;
import com.jsp.Job.dto.AddEmployeeDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController  implements EmployeeApi {

    private final EmployeeService employeeService;
    @Override
    public ResponseEntity < ResponseDTO > listOfEmployees ( ) {
        return employeeService.listOfAllEmployees();
    }

    @Override
    public ResponseEntity < ResponseDTO > addEmployee ( AddEmployeeDTO addEmployeeDTO ) {
        return employeeService.saveEmployee(addEmployeeDTO);
    }
}