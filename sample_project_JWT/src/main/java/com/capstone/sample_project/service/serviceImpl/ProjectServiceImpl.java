package com.capstone.sample_project.service.serviceImpl;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Project;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import com.capstone.sample_project.repository.ProjectRepository;
import com.capstone.sample_project.repository.UserRepository;
import com.capstone.sample_project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity < ResponseDto > getAllProject ( ) {
        List<Project> projectList= projectRepository.findAll ();
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Retrived All the Project Successfully",projectList) );
    }

    @Override
    public  ResponseEntity<ResponseDto> saveProject ( Project project ) {
         projectRepository.save ( project );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Project are Saved Successfully",project) );

    }

    @Override
    public  ResponseEntity<ResponseDto> deleteProjById ( String projectId ) {
        projectRepository.deleteById ( projectId );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Project Deleted By Id",null) );

    }

    @Override
    public  ResponseEntity<ResponseDto> deleteAllProj ( ) {
        projectRepository.deleteAll ();
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"All Project Deleted",null) );

    }

    @Override
    public  ResponseEntity<ResponseDto> addProjectInUser(String email, Project project) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.getProject ().add ( project );
            userRepository.save(user);
            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"User are added in Project ",user) );

        }
            else {
            throw new UserNotFoundException("User with email " + email + " not found");
        }
    }

}
