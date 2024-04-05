package com.jsp.Job.repository.service;

import com.jsp.Job.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceRepo {
    List< Employee> findAll ( );

    boolean existsEmployeesByEmpEmailAddress(String email);

    void save ( Employee employee );

    Optional < Employee > findById ( String employeeId );

    void deleteById ( String empId );

    void deleteAll ( );
}