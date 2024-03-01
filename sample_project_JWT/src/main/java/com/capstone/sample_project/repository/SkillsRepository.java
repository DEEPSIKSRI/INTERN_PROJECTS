package com.capstone.sample_project.repository;

import com.capstone.sample_project.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository< Skills,Integer> {
}
