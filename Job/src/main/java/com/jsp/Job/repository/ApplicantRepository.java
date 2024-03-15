package com.jsp.Job.repository;

import com.jsp.Job.entity.Applicant;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository< Applicant,Long > {
}