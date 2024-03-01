package com.example.Mapping.Demo.Service;

import com.example.Mapping.Demo.Entity.Department;
import com.example.Mapping.Demo.Entity.Employee;
import com.example.Mapping.Demo.Repository.DepartmentRepository;
import com.example.Mapping.Demo.Repository.MappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

}
