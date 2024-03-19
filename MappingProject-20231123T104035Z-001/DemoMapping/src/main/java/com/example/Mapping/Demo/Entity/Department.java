package com.example.Mapping.Demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Department")
public class Department {
    @Id
    private int D_id;
    private String D_name;
    @OneToMany(mappedBy = "department")
    private List<Employee> employee;
}
