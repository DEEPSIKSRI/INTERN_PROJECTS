package com.capstone.sample_project.repository;

import com.capstone.sample_project.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DepartmentRepository extends JpaRepository< Department,String > {
}
