package com.example.Mapping.Demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Project")
@Entity
public class Project {
    @Id
    private int Proj_id;
    private String Proj_name;
    @JsonIgnore
    @ManyToMany
    private Set<Student> students = new HashSet<>();
}
