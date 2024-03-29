package com.jsp.Job.repository;

import com.jsp.Job.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository< User,String> {

    boolean existsByUsername( String username );


    User findByUsername ( String username );

    User deleteByUsername ( String username );
}