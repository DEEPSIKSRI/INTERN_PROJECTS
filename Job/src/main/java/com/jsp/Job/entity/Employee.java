package com.jsp.Job.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incid;

    private String employeeId;

    private String firstName;

    private String lastName;

    private String middleName;

    private String address;

    private Date birthdate;

    private String birthplace;

    private Integer age;

    private String sex;

    private String civilStatus;

    private String telNo;

    private String empEmailAddress;

    private String cellNo;

    private String position;

    private String workStats;

    private String empPhoto;

    private String empUsername;

    private String empPassword;

    private Date dateHired;


    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;


}