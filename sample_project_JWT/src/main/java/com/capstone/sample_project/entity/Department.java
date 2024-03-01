package com.capstone.sample_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Department")
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    private String depId;

    private String depName;

    @OneToMany(mappedBy = "department",cascade = CascadeType.REMOVE)
    private List<User> users = new ArrayList <> ();

}


