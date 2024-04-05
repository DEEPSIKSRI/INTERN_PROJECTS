package com.jsp.Job.repository.service.Impl;

import com.jsp.Job.entity.Employee;
import com.jsp.Job.repository.EmployeeRepository;
import com.jsp.Job.repository.service.EmployeeServiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeRepoServiceImpl implements EmployeeServiceRepo {
    private final EmployeeRepository employeeRepository;

    @Override
    public List < Employee > findAll ( ) {
        return employeeRepository.findAll ();

    }

    @Override
    public boolean existsEmployeesByEmpEmailAddress ( String email ) {
        return employeeRepository.existsEmployeesByEmpEmailAddress ( email );
    }

    @Override
    public void save ( Employee employee ) {
        employeeRepository.save ( employee );
    }

    @Override
    public Optional < Employee > findById ( String employeeId ) {
        return employeeRepository.findById ( employeeId );
    }

    @Override
    public void deleteById ( String empId ) {
        employeeRepository.deleteById ( empId );
    }

    @Override
    public void deleteAll ( ) {
        employeeRepository.deleteAll ();
    }
}