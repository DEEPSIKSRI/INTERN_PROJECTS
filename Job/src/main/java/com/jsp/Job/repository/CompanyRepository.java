package com.jsp.Job.repository;

import com.jsp.Job.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository < Company, Integer > {

    Boolean existsCompanyByName(String name);

    Company findByCompanyId(Integer companyId);

   @Query("select c.name from Company as c ")
   List<String> findAllByCompanyName( );

   Company findCompanyByName(String companyName);
}