package com.capstone.sample_project.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="USER_TABLE")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String email;

    private String password;

    private String first_name;

    private String last_name;

    @Enumerated(EnumType.STRING)
    private Role role;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "depId")
    private Department department;

//    @OneToMany(mappedBy = "userId", cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    private List < Skills > skills;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JsonIgnore
    @JoinTable(
            name = "USER_PROJECT",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> project;


    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private Address address;

    private String token;

}