package com.example.divum.controller;

import com.example.divum.model.Employee;
import com.example.divum.repository.EmailValidation.checkEmail;
import com.example.divum.repository.EmployeeRepository;
import com.example.divum.repository.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PageRanges;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/divum")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private checkEmail checkEmail;

    @GetMapping
    @CrossOrigin
    public List<Employee> getAllEmployee(){
    return employeeRepository.findTop10ByOrderByLastDesc();
//        return employeeRepository.findAll();
    }

    @GetMapping("/deepsi")
    public List<Employee> getAllRecords()
    {
        return employeeRepository.findAll();
    }
    @PostMapping
    public Employee CreateEmployee(@RequestBody Employee employee)
    {

       // employee.setLast(new Timestamp(System.currentTimeMillis()));
        return employeeRepository.save(employee);
    }
    @GetMapping("check/{email}")
    public boolean CheckEmail(@PathVariable(value="email") String email)
    {
        Employee emp=employeeRepository.findByEmail(email);
        if(emp==null)
        {
            return true;
        }
        else {
            return false;
        }
    }

    @DeleteMapping("{id}")
   public String deleteEmployee(@PathVariable(value="id") Integer identity)
    {
        employeeRepository.deleteById(identity);
        return "Successfully deleted";
    }
  @GetMapping("{id}")
  public Optional<Employee> getRecords(@PathVariable(value="id") Integer identity )
  {
      return employeeRepository.findById(identity);
  }


    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee  employeeDetails)
    {
        Employee updateEmployee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("id not found"));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmail(employeeDetails.getEmail());
        updateEmployee.setAddress(employeeDetails.getAddress());
        updateEmployee.setDOB(employeeDetails.getDOB());
        updateEmployee.setMobileNumber(employeeDetails.getMobileNumber());
        updateEmployee.setLast(new Timestamp(System.currentTimeMillis()));
        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);

    }
//    @GetMapping("/{id}/{pageNo}/{recordCount}")
//    public List<Employee> getAllEmployee(@PathVariable int pageNo,int recordCount)
//    {
//        Pageable pageable= (Pageable) PageRequest.of(pageNo,recordCount);
//        return employeeRepository.findAll((org.springframework.data.domain.Pageable) pageable).get().toList();
//    }
    @GetMapping("/page/{page}/{size}")
    @CrossOrigin()
    public List<Employee> displayPaging(@PathVariable int page,@PathVariable int size){
        Pageable pageable=(Pageable)PageRequest.of(page,size);
        return employeeRepository.findAllBylast(pageable);
    }
}
