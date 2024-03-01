package com.capstone.sample_project.repository;

import com.capstone.sample_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository< User,String> {
    User findByEmail ( String username );
}
