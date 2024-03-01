package com.example.Mapping.Demo.service;

import com.example.Mapping.Demo.entity.Department;
import com.example.Mapping.Demo.entity.Employee;
import com.example.Mapping.Demo.repository.DepartmentRepository;
import com.example.Mapping.Demo.repository.MappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MappingService {

   @Autowired
   MappingRepository mappingRepository;
    @Autowired
    DepartmentRepository departmentRepository;


    public MappingService(MappingRepository mappingRepository) {
        this.mappingRepository = mappingRepository;
    }

    public List<Employee> viewEmployee()
    {
        return  mappingRepository.findAll();
    }
    public  Employee saveDetails(Employee employee)
    {
        return mappingRepository.save(employee);
    }
    public String deleteEmployee(Integer id)
    {
       mappingRepository.deleteById(id);
       return "Deleted successfully";
    }

    public Employee saveEmployee(Employee employee)
    {
        return mappingRepository.save(employee);
    }


    public Optional<Employee> getEmpDep(Integer empDepId) {
        return mappingRepository.findById(empDepId);
    }

    public Department saveDep(Department department) {
        return departmentRepository.save(department);
    }


    public Employee getDepEmpl(Integer empDepId, Integer eId) {
        List<Employee> employeeList=new ArrayList<>();
        Employee employee=mappingRepository.findById(eId).get();
        Department department=departmentRepository.findById(empDepId).get();
        employee.getDepartment();
        department.getD_id();
        department.getD_name();
        employee.setDepartment(department);
        employeeList.add(employee);
        return mappingRepository.save(employee);
    }

    public String deleteAll ( ) {
        mappingRepository.deleteAll ();
        return "Successfully Deleted";
    }
}
