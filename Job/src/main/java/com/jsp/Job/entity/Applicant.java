package com.jsp.Job.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;


@Entity
@Data
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicantId;

    private String firstName;

    private String lastName;

    private String middleName;

    private String address;

    private String sex;

    private String civilStatus;

    private LocalDate birthDate;

    private String birthPlace;

    private Integer age;

    private String username;

    private String password;

    private String emailAddress;

    private String contactNumber;

    private String degree;

    private String applicantPhoto;

    private String nationalId;
}