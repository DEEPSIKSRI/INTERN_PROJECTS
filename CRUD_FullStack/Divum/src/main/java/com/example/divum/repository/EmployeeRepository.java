package com.example.divum.repository;


import com.example.divum.model.Employee;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    String deleteById(SingularAttribute<AbstractPersistable, Serializable> id);
    List<Employee> findTop10ByOrderByLastDesc();
    List<Employee> findAll();
    Employee findByEmail(String email);

    @Query(value="Select * from divum order by last desc",nativeQuery = true)
    List<Employee> findAllBylast(Pageable pageable);
}
