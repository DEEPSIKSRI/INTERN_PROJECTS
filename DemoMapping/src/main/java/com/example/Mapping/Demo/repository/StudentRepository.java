package com.example.Mapping.Demo.repository;

import com.example.Mapping.Demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {


    UserDetails findByEmail(String username);
}


