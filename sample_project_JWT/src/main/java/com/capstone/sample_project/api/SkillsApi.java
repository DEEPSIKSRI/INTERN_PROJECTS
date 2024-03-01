package com.capstone.sample_project.api;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Skills;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/skills")
public interface SkillsApi {

    @GetMapping("/getSkills")
    ResponseEntity< ResponseDto > getAllSkills();

    @PostMapping("/addSkills")
    ResponseEntity<ResponseDto> addSkills(@RequestBody Skills skills);

    @PostMapping("/addUserId/{email}")
    ResponseEntity<ResponseDto> addUserId( @RequestBody Skills skills, @PathVariable (value="email") String userEmail  ) throws UserNotFoundException;

    @DeleteMapping("/deleteAllSkills")
    ResponseEntity<ResponseDto> deleteAllSkills();

    @DeleteMapping("/deleteskillsById/{skillsId}")
    ResponseEntity<ResponseDto> deleteSkillsById(@PathVariable (value="skillsId") Integer skillsId);
}
