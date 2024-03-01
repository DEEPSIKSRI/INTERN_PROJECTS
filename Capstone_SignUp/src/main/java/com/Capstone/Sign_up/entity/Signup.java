package com.Capstone.Sign_up.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Sign_up")
public class Signup {

    @Id
    @Column(name = "email")
    private String email;

    private String firstname;

    private String lastname;

    private String password;

    private String gender;

    private String date_of_birth;



}

