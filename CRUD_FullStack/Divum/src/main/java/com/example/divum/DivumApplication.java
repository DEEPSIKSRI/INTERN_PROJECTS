package com.example.divum;

import com.example.divum.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.divum.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaRepositories
public class DivumApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DivumApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
      Employee employee = new Employee();
      employee.setFirstName("Deepsi");
       employee.setLastName("Sri");
      employee.setEmail("deepsi@example.com");
        employee.setDOB("20/09/2003");
      employee.setAddress("nkl");

//        // Save the employee to the repository
        employeeRepository.save(employee);
    }
//    @Bean
//    public WebMvcConfigurer configure() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry reg) {
//                reg.addMapping("/**").allowedOrigins("*");
//            }
//        };
//
//    }
}
