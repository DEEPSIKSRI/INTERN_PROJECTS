package com.jsp.Job.repository;

import com.jsp.Job.entity.JobRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRegistrationRepository extends JpaRepository< JobRegistration,Long > {
}