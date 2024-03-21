package com.jsp.Job.repository;

import com.jsp.Job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository< Job,Long > {

    List<Job> findByCompanyId(Integer companyId);

    boolean existsByOccupationTitle(String occupationTittle);

    List<Job> findByOccupationTitle( String occupationTitle );

    List<Job> findByCategory(String category);

    List<Job> findByCompanyIdAndOccupationTitle( Integer companyId , String occupationTitle ) ;

    @Query("select j.occupationTitle from Job as j")
    List<String> findAllByOccupationTitle();
}