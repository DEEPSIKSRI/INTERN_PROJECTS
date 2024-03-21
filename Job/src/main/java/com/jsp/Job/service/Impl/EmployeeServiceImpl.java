package com.jsp.Job.service.Impl;

import com.jsp.Job.dto.AddEmployeeDTO;
import com.jsp.Job.dto.EmployeeDetailsDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Company;
import com.jsp.Job.entity.Employee;
import com.jsp.Job.repository.service.EmployeeServiceRepo;
import com.jsp.Job.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeServiceRepo employeeServiceRepo;

    @Override
    public ResponseEntity < ResponseDTO > listOfAllEmployees ( ) {
        List <Employee> employee=employeeServiceRepo.findAll();
        List< EmployeeDetailsDTO > employeeDetailsDTOS=employee.stream( ).map (
                employee1 -> {
                  EmployeeDetailsDTO employeeDetailsDTO=new EmployeeDetailsDTO ();
                  employeeDetailsDTO.setEmployeeId ( employee1.getEmployeeId ( ) );
                  employeeDetailsDTO.setFirstName ( employee1.getFirstName ( ) );
                  employeeDetailsDTO.setCellNo ( employee1.getCellNo ( ) );
                  employeeDetailsDTO.setPosition ( employee1.getPosition ( ) );
                  employeeDetailsDTO.setSex ( employee1.getSex ( ) );
                  employeeDetailsDTO.setAge ( employee1.getAge () );
                  employeeDetailsDTO.setAddress ( employee1.getAddress ( ) );
                  return employeeDetailsDTO;
                }
        ).toList ();

        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true,HttpStatus.OK,"List of Employee Details!!",employeeDetailsDTOS ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > saveEmployee ( AddEmployeeDTO addEmployeeDTO ) {
        if(employeeServiceRepo.existsEmployeesByEmpEmailAddress ( addEmployeeDTO.getEmpEmailAddress ( ) ))
        {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false,HttpStatus.BAD_REQUEST,"Employee Already Exists!!","" ) );
        }
        Employee employee = new Employee();
        employee.setFirstName(addEmployeeDTO.getFirstName());
        employee.setLastName(addEmployeeDTO.getLastName());
        employee.setMiddleName(addEmployeeDTO.getMiddleName());
        employee.setAddress(addEmployeeDTO.getAddress());
        employee.setBirthdate(addEmployeeDTO.getBirthdate());
        employee.setBirthplace(addEmployeeDTO.getBirthplace());
        employee.setAge(addEmployeeDTO.getAge());
        employee.setSex(addEmployeeDTO.getSex());
        employee.setCivilStatus(addEmployeeDTO.getCivilStatus());
        employee.setPosition(addEmployeeDTO.getPosition());
        employee.setEmpEmailAddress(addEmployeeDTO.getEmpEmailAddress());
        employee.setCellNo(addEmployeeDTO.getCellNo());
        Company company=new Company ();
        company.setName ( addEmployeeDTO.getCompanyName ( ) );
        employee.setCompany (company);
        employeeServiceRepo.save(employee);
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true,HttpStatus.OK,"Employee Added Successfully!!",employee ) );
    }
}