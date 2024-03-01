package com.example.divum.repository.EmailValidation.Innerpackage;

import com.example.divum.model.Employee;
import com.example.divum.repository.EmailValidation.checkEmail;
import com.example.divum.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailImplementation implements checkEmail {
    @Autowired
    EmployeeRepository repo;

    public Employee FindByEmail(String email){
        return repo.findByEmail(email);
    }
}
