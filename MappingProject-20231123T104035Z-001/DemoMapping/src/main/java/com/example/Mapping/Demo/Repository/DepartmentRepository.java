package com.example.Mapping.Demo.Repository;

import com.example.Mapping.Demo.Entity.Department;
import com.example.Mapping.Demo.Entity.Employee;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
//    Optional<Employee> findById(Integer empDepId, Integer eId);
}
