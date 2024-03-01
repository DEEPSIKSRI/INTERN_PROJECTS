package com.capstone.sample_project.service;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

     ResponseEntity<ResponseDto> getAllUsers();

     ResponseEntity<ResponseDto> saveUser(User user);

    ResponseEntity<ResponseDto> deleteAllUser ();

    ResponseEntity<ResponseDto> saveDepUser ( User user, String depId);

    ResponseEntity<ResponseDto> deleteById ( String email );

//   ResponseEntity<ResponseDto>  getAll(String token);

}
