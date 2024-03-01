package com.capstone.sample_project.repository;

import com.capstone.sample_project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository< Project,String> {
}
