package com.example.JWT.JWT.service;

import com.example.JWT.JWT.Exception.ResourceNotFoundException;
import com.example.JWT.JWT.model.JwtModel;
import com.example.JWT.JWT.model.Role;
import com.example.JWT.JWT.repository.UserRepository;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class TokenService {

    @Autowired
    UserRepository userRepository;
    public List<JwtModel> recordGet() {
        return userRepository.findAll();
    }

    public JwtModel recordSave(JwtModel jwtModel)
    {
        return userRepository.save(jwtModel);
    }

    public String recordDelete(Integer user_id) {
        userRepository.deleteById(user_id);
        return "Successfully deleted";
    }
    public JwtModel recordUpdate(Integer user_id, @org.jetbrains.annotations.NotNull JwtModel jwtModel)
    {
        System.out.println(jwtModel+"  role");
        JwtModel oldrecord=userRepository.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("Username not found"));
        oldrecord.setFirstName(jwtModel.getFirstName());
        oldrecord.setLastName(jwtModel.getLastName());
        oldrecord.setPassword(jwtModel.getPassword());
        oldrecord.setRole(jwtModel.getRole());
        return userRepository.save(oldrecord);
    }


    public String deleteAll() {
        userRepository.deleteAll();
        return "Deleted All Records";
    }
}

