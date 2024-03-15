package com.jsp.Job.repository;

import com.jsp.Job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository< Job,Integer > {
}