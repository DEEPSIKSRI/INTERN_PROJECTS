package com.jsp.Job.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "UserJob")
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    private String fullName;

    private String username;

    private String password;

    private String role;

    private String picLocation;

    private String token;


}