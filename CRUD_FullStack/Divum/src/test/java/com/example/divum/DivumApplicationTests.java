package com.example.divum;
import com.example.divum.controller.EmployeeController;
import com.example.divum.model.Employee;
import com.example.divum.repository.EmailValidation.checkEmail;
import com.example.divum.repository.EmployeeRepository;
import com.example.divum.repository.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DivumApplicationTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private checkEmail checkEmail;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        when(employeeRepository.findTop10ByOrderByLastDesc()).thenReturn(employees);
        List<Employee> result = employeeController.getAllEmployee();
        assertEquals(employees, result);
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setEmail("test@example.com");
        when(checkEmail.FindByEmail(any())).thenReturn(null);
        when(employeeRepository.save(any())).thenReturn(employee);
        Employee createdEmployee = employeeController.CreateEmployee(employee);
        assertEquals(employee.getEmail(), createdEmployee.getEmail());
    }

    @Test
    public void testDeleteEmployee() {
        Integer employeeId = 1;
        String result = employeeController.deleteEmployee(employeeId);
        assertEquals("Successfully deleted", result);;
    }


    @Test
    public void testUpdateEmployee() {
        int employeeId = 1 ;
        Employee existingEmployee = new Employee();
        Employee updatedEmployee = new Employee();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(existingEmployee));
        when(employeeRepository.save(any())).thenReturn(updatedEmployee);
        ResponseEntity<Employee> responseEntity = employeeController.updateEmployee(employeeId, updatedEmployee);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedEmployee, responseEntity.getBody());
    }

}
