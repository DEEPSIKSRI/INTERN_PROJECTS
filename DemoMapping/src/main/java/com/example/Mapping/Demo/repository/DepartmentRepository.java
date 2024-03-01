package com.example.Mapping.Demo.repository;

import com.example.Mapping.Demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
//    Optional<Employee> findById(Integer empDepId, Integer eId);
}
