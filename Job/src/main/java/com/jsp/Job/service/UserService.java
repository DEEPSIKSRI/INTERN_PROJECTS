package com.jsp.Job.service;

import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity < ResponseDTO > addUser ( UserDTO userDTO );

    ResponseEntity < ResponseDTO > getAllUser ( );

    ResponseEntity < ResponseDTO > deleteAll ( );

    ResponseEntity < ResponseDTO > deleteParticularUser ( String username );
}