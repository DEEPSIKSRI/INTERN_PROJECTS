package com.example.Mapping.Demo.Repository;

import com.example.Mapping.Demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}


