package com.jsp.Job.repository;

import com.jsp.Job.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository < Company, Integer > {

    Boolean existsCompanyByName(String name);
}