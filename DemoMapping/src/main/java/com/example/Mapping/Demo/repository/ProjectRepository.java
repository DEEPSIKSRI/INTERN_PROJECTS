package com.example.Mapping.Demo.repository;

import com.example.Mapping.Demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
