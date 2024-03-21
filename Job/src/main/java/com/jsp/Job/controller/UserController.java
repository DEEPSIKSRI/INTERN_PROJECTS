package com.jsp.Job.controller;

import com.jsp.Job.api.UserApi;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.dto.UserDTO;
import com.jsp.Job.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    @Override
    public ResponseEntity < ResponseDTO > addUser ( UserDTO userDTO ) {
        return  userService.addUser(userDTO);
    }

    @Override
    public ResponseEntity < ResponseDTO > getAllUser ( ) {
        return userService.getAllUser();
    }

    @Override
    public ResponseEntity < ResponseDTO > deleteAllUsers ( ) {
        return userService.deleteAll();
    }

    @Override
    public ResponseEntity < ResponseDTO > deleteParticularUser ( String username ) {
        return userService.deleteParticularUser(username);
    }
}