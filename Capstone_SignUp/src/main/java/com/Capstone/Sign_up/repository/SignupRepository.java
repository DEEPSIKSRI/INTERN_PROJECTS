package com.Capstone.Sign_up.repository;

import com.Capstone.Sign_up.entity.Signup;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SignupRepository extends JpaRepository<Signup, String> {
    boolean existsByEmailIgnoreCase(String email);
}

