package com.example.JWT.JWT.repository;

import com.example.JWT.JWT.model.JwtModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<JwtModel,Integer> {

    UserDetails findByEmail(String username);


}
