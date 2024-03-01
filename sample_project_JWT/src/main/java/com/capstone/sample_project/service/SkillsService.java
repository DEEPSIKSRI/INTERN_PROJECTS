package com.capstone.sample_project.service;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Skills;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillsService {
   ResponseEntity< ResponseDto > getSkills ( );

    ResponseEntity<ResponseDto> addSkills ( Skills skills );

    ResponseEntity<ResponseDto> addUserId ( Skills skills , String userEmail ) throws UserNotFoundException;

    ResponseEntity<ResponseDto> deleteAllSkills ( );

    ResponseEntity<ResponseDto> deleteSkillsById ( Integer skillsId );
}
