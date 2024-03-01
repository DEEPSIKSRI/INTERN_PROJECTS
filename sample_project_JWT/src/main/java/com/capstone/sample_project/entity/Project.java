package com.capstone.sample_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Project")

public class Project {

    @Id
    private String projectId;

    private String projectName;

    @ManyToMany(mappedBy = "project",cascade = CascadeType.ALL)
    private List<User> users;
}
