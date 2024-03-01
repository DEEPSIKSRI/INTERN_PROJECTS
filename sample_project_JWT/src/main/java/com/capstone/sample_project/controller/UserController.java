package com.capstone.sample_project.controller;

import com.capstone.sample_project.api.UserApi;
import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Department;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.service.serviceImpl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserController implements UserApi {

    @Autowired
    UserServiceImpl userService;

    @Override
    public ResponseEntity<ResponseDto> getAllUser ( ) {
        log.info ( "GetAllUser" );
        return userService.getAllUsers ();
    }

    @Override
    public ResponseEntity<ResponseDto> saveUser ( @RequestBody User user ) {
        return userService.saveUser(user);
    }

    @Override
    public ResponseEntity<ResponseDto> deleteAllUser ( ) {
        return userService.deleteAllUser();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteById ( String email ) {
        return userService.deleteById(email);
    }

    @Override
    public ResponseEntity<ResponseDto> saveDepInUser ( User user , String depId ) {
        return userService.saveDepUser ( user,depId );
    }

//    @Override
//    public ResponseEntity < ResponseDto > getAll ( ) {
//        return userService.getAll ();
//    }


}
