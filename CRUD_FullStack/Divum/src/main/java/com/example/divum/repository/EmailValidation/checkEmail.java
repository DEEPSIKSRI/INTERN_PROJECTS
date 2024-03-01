package com.example.divum.repository.EmailValidation;

import com.example.divum.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface checkEmail {
    Employee FindByEmail(String email);

}
