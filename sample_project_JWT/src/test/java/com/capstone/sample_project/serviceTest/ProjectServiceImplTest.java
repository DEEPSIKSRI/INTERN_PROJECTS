package com.capstone.sample_project.serviceTest;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Project;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import com.capstone.sample_project.repository.ProjectRepository;
import com.capstone.sample_project.repository.UserRepository;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    ProjectServiceImpl projectService;

    @BeforeEach
    void setUp ( ) {
        MockitoAnnotations.openMocks ( this );
    }

    @Test
     void testGetAllProject()
    {
        Project project=mock(Project.class);
        List< Project > projectList=new ArrayList <> ();
        projectList.add ( project );
        when ( projectRepository.findAll () ).thenReturn ( projectList );

        ResponseEntity< ResponseDto > response=projectService.getAllProject ();

        assertEquals( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Retrived All the Project Successfully",response.getBody ().getMessage () );
    }

    @Test
    void testSaveProject()
    {
        Project project=mock ( Project.class );
        when ( projectRepository.save ( project ) ).thenReturn ( project );

        ResponseEntity<ResponseDto> response=projectService.saveProject ( project );
        assertEquals( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Project are Saved Successfully",response.getBody ().getMessage () );
    }

    @Test
    void testDeleteProjByd()
    {
        String projectId="1";
        ResponseEntity<ResponseDto> response=projectService.deleteProjById ( projectId );
        assertEquals( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Project Deleted By Id",response.getBody ().getMessage () );
    }

    @Test
    void testDeleteAllPro()
    {
        ResponseEntity<ResponseDto> response=projectService.deleteAllProj ();
        assertEquals( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "All Project Deleted",response.getBody ().getMessage () );
    }

    @Test
    void testAddProjUser() throws UserNotFoundException
    {
        String id="dfghjkl";
       Project project=mock ( Project.class );

       User user=mock ( User.class );
        when ( userRepository.findById ( id ) ).thenReturn ( Optional.of ( user ) );

        ResponseEntity<ResponseDto> response=projectService.addProjectInUser ( id,project );
//        when ( userRepository.save ( user ) ).thenReturn ( user );

        assertEquals( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "User are added in Project ",response.getBody ().getMessage () );

}

@Test
void testUser_NotFound_Exception() throws UserNotFoundException {
  String id="ghjkl;'";
    Project project = mock ( Project.class );

    when ( userRepository.findById ( id ) ).thenReturn ( Optional.empty ( ) );

    assertThrows ( UserNotFoundException.class,()->{projectService.addProjectInUser ( id , project );
    });

}
}
