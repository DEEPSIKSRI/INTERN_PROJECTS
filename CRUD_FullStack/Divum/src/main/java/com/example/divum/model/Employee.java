package com.example.divum.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DIVUM")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="FirstName")
    private String FirstName;
    @Column(name="LastName")
    private String LastName;
    @Column(name="DOB")
    private String DOB;
    @Column(name="Email")
    private String email;
    @Column(name="MobileNumber")
    private String MobileNumber;
    @Column(name="Address")
    private String Address;
    private Timestamp last;
}
