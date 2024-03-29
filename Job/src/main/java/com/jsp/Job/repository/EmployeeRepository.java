package com.jsp.Job.repository;

import com.jsp.Job.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository< Employee,Long > {

    boolean existsEmployeesByEmpEmailAddress(String email);
}