package com.capstone.sample_project.controllerTest;

import com.capstone.sample_project.controller.ProjectController;
import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Project;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import com.capstone.sample_project.service.serviceImpl.ProjectServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjectControllerTest {

    @Mock
    ProjectServiceImpl projectService;
    @InjectMocks
    ProjectController projectController;

    @BeforeEach
    void setUp ( ) {
        MockitoAnnotations.openMocks ( this );
    }

    @Test
    void testGetAllPro()
    {
        Project project= mock( Project.class );
        List<Project> projectList=new ArrayList <> ();
        projectList.add ( project );
        ResponseEntity < ResponseDto > responseEntity = ResponseEntity.status( HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK, "Retrieved All the Project Successfully", projectList));

        when(projectService.getAllProject ()).thenReturn(responseEntity);

        ResponseEntity<ResponseDto> response=projectController.getProject ();
        assertEquals( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Retrieved All the Project Successfully",response.getBody ().getMessage () );
    }

    @Test
    void testSaveProject()
    {
        Project project=mock ( Project.class );
        when(projectService.saveProject (project)).thenReturn(ResponseEntity.status( HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK, "Project are Saved Successfully", project)));
        ResponseEntity<ResponseDto> response=projectController.saveProject ( project );
        assertEquals( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Project are Saved Successfully",response.getBody ().getMessage () );
    }

    @Test
    void testDeleteAll()
    {

        when ( projectService.deleteAllProj () ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"All Project Deleted",null ) ) );
        ResponseEntity<ResponseDto> response=projectController.deleteAllProj ();

        assertEquals( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "All Project Deleted",response.getBody ().getMessage () );
    }

    @Test
    void testDeleteById()
    {
        String id="1";
        when ( projectService.deleteProjById (  id) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"Project Deleted By Id",null ) ) );
        ResponseEntity<ResponseDto> response=projectController.deleteProjById (id);

        assertEquals( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Project Deleted By Id",response.getBody ().getMessage () );
    }

    @Test
    void testAddProjeUser() throws UserNotFoundException {
        String id="il;";
        Project project=mock ( Project.class );
        User user=mock ( User.class );

        ResponseEntity < ResponseDto > responseEntity = ResponseEntity.status( HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK, "User are added in Project", project));

        when ( projectController.addUserProject ( id,project ) ).thenReturn ( responseEntity );

        ResponseEntity<ResponseDto> response=projectService.addProjectInUser ( id,project );
//        when ( userRepository.save ( user ) ).thenReturn ( user );

        assertEquals( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "User are added in Project",response.getBody ().getMessage () );

    }
}
