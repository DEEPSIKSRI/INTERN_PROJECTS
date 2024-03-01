package com.capstone.sample_project.controller;

import com.capstone.sample_project.api.ProjectApi;
import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Project;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import com.capstone.sample_project.service.serviceImpl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController implements ProjectApi {

    @Autowired
    ProjectServiceImpl projectService;


    @Override
    public ResponseEntity < ResponseDto > getProject ( ) {
        return projectService.getAllProject ();
    }

    @Override
    public  ResponseEntity<ResponseDto> saveProject ( Project project ) {
        return projectService.saveProject ( project );
    }

    @Override
    public  ResponseEntity<ResponseDto> addUserProject ( String email , Project project ) throws UserNotFoundException {
        return projectService.addProjectInUser(email,project);
    }

    @Override
    public  ResponseEntity<ResponseDto> deleteAllProj ( ) {
        return projectService.deleteAllProj ();
    }

    @Override
    public  ResponseEntity<ResponseDto> deleteProjById ( String projectId ) {
        return projectService.deleteProjById ( projectId );
    }
}
