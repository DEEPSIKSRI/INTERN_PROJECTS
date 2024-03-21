package com.jsp.Job.service.Impl;

import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.dto.UserDTO;
import com.jsp.Job.entity.User;
import com.jsp.Job.repository.service.UserServiceRepo;
import com.jsp.Job.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserServiceRepo userServiceRepo;

    @Override
    public ResponseEntity < ResponseDTO > addUser ( UserDTO userDTO ) {
        if(userServiceRepo.existsByUsername ( userDTO.getUsername () ))
        {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false,HttpStatus.BAD_REQUEST,"User is Already Exists","" ) );
        }
        User user=new User ();
        user.setUsername ( userDTO.getUsername ( ) );
        user.setFullName ( userDTO.getFullName ( ) );
        user.setPicLocation ( userDTO.getPicLocation ( ) );
        user.setPassword ( userDTO.getPassword ( ) );
        user.setRole ( userDTO.getRole ( ) );
        userServiceRepo.save(user);
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true,HttpStatus.OK,"User is Registered Successfully!!","" ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > getAllUser ( ) {
        List<User> users= userServiceRepo.findAll();
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true,HttpStatus.OK,"Retrieved All the Users!!",users ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > deleteAll ( ) {
        userServiceRepo.deleteAll();
        return   ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true,HttpStatus.OK,"Deleted All Users Successfully!","" ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > deleteParticularUser ( String username ) {
        User user=userServiceRepo.findByUsername ( username );
        if(user==null)
        {
            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( false,HttpStatus.BAD_REQUEST,"User Not Found" ,"") );
        }

        userServiceRepo.deleteByUsername(user.getUsername ()) ;
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true,HttpStatus.OK,"User is Deleted Successfully","" ) );
    }
}