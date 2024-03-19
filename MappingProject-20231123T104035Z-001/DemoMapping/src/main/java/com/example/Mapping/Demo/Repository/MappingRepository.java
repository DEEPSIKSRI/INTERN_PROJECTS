package com.example.Mapping.Demo.Repository;


import com.example.Mapping.Demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MappingRepository extends JpaRepository<Employee, Integer> {

}
