package com.example.Mapping.Demo.Repository;

import com.example.Mapping.Demo.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
