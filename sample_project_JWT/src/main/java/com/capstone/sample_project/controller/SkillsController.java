package com.capstone.sample_project.controller;

import com.capstone.sample_project.api.SkillsApi;
import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Skills;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import com.capstone.sample_project.repository.UserRepository;
import com.capstone.sample_project.service.serviceImpl.SkillsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/skills")

public class SkillsController implements SkillsApi {

    @Autowired
    SkillsServiceImpl skillsService;

    @Autowired
    UserRepository userRepository;


    @Override
    public ResponseEntity< ResponseDto> getAllSkills ( ) {
        return skillsService.getSkills();
    }

    @Override
    public ResponseEntity< ResponseDto> addSkills ( @RequestBody Skills skills ) {
        return skillsService.addSkills(skills);
    }

    @Override
    public ResponseEntity< ResponseDto> addUserId ( Skills skills , String userEmail  ) throws UserNotFoundException {
       return skillsService.addUserId(skills,userEmail);


    }

    @Override
    public ResponseEntity< ResponseDto> deleteAllSkills ( ) {
        return  skillsService.deleteAllSkills();
    }

    @Override
    public ResponseEntity< ResponseDto> deleteSkillsById ( Integer skillsId ) {
        return skillsService.deleteSkillsById(skillsId);
    }
}
