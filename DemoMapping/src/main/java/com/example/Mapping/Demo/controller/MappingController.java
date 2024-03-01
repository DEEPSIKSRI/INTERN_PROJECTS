package com.example.Mapping.Demo.controller;

import com.example.Mapping.Demo.entity.Department;
import com.example.Mapping.Demo.entity.Employee;
import com.example.Mapping.Demo.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mapping")
public class MappingController {

    @Autowired
    MappingService mappingService;


    @GetMapping("/get")
    public List<Employee> getEmployee() {
        return mappingService.viewEmployee();
    }
    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        return mappingService.saveDetails(employee);
    }

    @DeleteMapping("/delete/{e_id}")
    public String deleteEmployee(@PathVariable(value = "e_id") Integer id)
    {
        return mappingService.deleteEmployee(id);
    }
    @PostMapping("/saveRecords")
    public  Employee saveRecords(@RequestBody Employee employee)
    {
        return mappingService.saveEmployee(employee);
    }
    @GetMapping("/getEmpDep/{EmpDep_Id}")
    public Optional<Employee> getEmpDep(@PathVariable (value="EmpDep_Id")Integer EmpDep_Id)
    {
        return mappingService.getEmpDep(EmpDep_Id);
    }
    @PostMapping("/saveDep")
    public Department saveDep(@RequestBody Department department)
    {
        return mappingService.saveDep(department);
    }
    @GetMapping("/storeDep/{E_id}/{EmpDep_Id}")
    public Employee getDepEmpl(@PathVariable (value="EmpDep_Id")Integer EmpDep_Id,
                                         @PathVariable (value = "E_id") Integer E_id)
    {
        return mappingService.getDepEmpl(EmpDep_Id,E_id);
    }
    @DeleteMapping("delete")
    public String deleteEmpl()
    {
        return mappingService.deleteAll();
    }

}

