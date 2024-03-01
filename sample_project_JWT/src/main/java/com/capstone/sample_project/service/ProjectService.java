package com.capstone.sample_project.service;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Project;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface ProjectService {

    ResponseEntity < ResponseDto > getAllProject();

    ResponseEntity<ResponseDto> saveProject(Project project);

    ResponseEntity<ResponseDto> deleteProjById(String projectId);

    ResponseEntity<ResponseDto> deleteAllProj();

    ResponseEntity<ResponseDto> addProjectInUser ( String email , Project project ) throws UserNotFoundException;
}
