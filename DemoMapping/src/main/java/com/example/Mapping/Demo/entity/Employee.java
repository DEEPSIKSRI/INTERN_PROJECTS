package com.example.Mapping.Demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Employee_Details")
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int E_id;
    private String E_Name;
    private int E_Age;
    //foreign key will generate default so i have given custome name
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Forign_Key_A_id")
    private Address address;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "EmpDep_Id")
    private  Department department;

}