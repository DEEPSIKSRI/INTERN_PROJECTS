package com.example.Mapping.Demo.repository;


import com.example.Mapping.Demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingRepository extends JpaRepository<Employee, Integer> {

}
