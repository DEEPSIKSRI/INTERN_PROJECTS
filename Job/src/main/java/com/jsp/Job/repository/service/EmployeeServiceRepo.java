package com.jsp.Job.repository.service;

import com.jsp.Job.entity.Employee;

import java.util.List;

public interface EmployeeServiceRepo {
    List< Employee> findAll ( );

    boolean existsEmployeesByEmpEmailAddress(String email);

    void save ( Employee employee );
}