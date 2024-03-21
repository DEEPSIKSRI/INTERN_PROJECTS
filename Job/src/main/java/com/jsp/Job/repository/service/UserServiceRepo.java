package com.jsp.Job.repository.service;

import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceRepo {

    boolean existsByUsername( String username );

    void save ( User user );

    User findByUsername ( String username );

    List <User> findAll ( );

    void deleteAll ( );

    User deleteByUsername ( String username );
}