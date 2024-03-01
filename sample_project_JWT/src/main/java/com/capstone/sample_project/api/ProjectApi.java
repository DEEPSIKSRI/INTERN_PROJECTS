package com.capstone.sample_project.api;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Project;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")

public interface ProjectApi {

    @GetMapping("/getProject")
    ResponseEntity < ResponseDto > getProject();

    @PostMapping("/saveProject")
    ResponseEntity<ResponseDto> saveProject(@RequestBody Project project);

    @PostMapping("/addUser/{email}")
    ResponseEntity<ResponseDto> addUserProject(@PathVariable (value = "email") String email,@RequestBody Project project) throws UserNotFoundException;


    @DeleteMapping("/deleteAllProject")
    ResponseEntity<ResponseDto> deleteAllProj();

    @DeleteMapping("/deleteProjById/{projectId}")
    ResponseEntity<ResponseDto> deleteProjById(@PathVariable (value = "projectId") String projectId);
}
