package com.jsp.Job.repository;

import com.jsp.Job.entity.AutoNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoNumbersRepository extends JpaRepository< AutoNumbers,Integer > {
}