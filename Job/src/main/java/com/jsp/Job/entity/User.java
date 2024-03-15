package com.jsp.Job.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "User_Table")
public class User {

    @Id
    private String userId;

    private String fullName;

    private String username;

    private String password;

    private String role;

    private String picLocation;


}