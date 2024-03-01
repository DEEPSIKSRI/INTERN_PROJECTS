package com.capstone.sample_project.serviceTest;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Skills;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import com.capstone.sample_project.repository.SkillsRepository;
import com.capstone.sample_project.repository.UserRepository;
import com.capstone.sample_project.service.serviceImpl.SkillsServiceImpl;
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

class SkillServiceTest {

    @Mock
    SkillsRepository skillsRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    SkillsServiceImpl skillsService;


    @BeforeEach
    void setUp ( ) {
        MockitoAnnotations.openMocks ( this );
    }

    @Test
    void testGetSkills()
    {

        Skills skills=mock ( Skills.class );
        List <Skills> skillsArrayList=new ArrayList <> ();
        skillsArrayList.add ( skills );
        when(skillsRepository.findAll ()).thenReturn(skillsArrayList);
        ResponseEntity < ResponseDto > response=skillsService.getSkills ();

        assertEquals( HttpStatus.OK,response.getStatusCode ());
        assertEquals("Retrived All the Skills",response.getBody ().getMessage ());
    }
    @Test
    void testAddSkills()
    {
        Skills skills=mock ( Skills.class );
        when ( skillsRepository.save ( skills ) ).thenReturn ( skills );

        ResponseEntity<ResponseDto> response=skillsService.addSkills ( skills );

        assertEquals ( HttpStatus.OK,response.getStatusCode ());
        assertEquals ( "Skills are Saved Successfully!",response.getBody ().getMessage () );
    }
    @Test
    void testDeleteAll()
    {
        String deleteAll="Skills Record is Deleted";
        ResponseEntity<ResponseDto> response=skillsService.deleteAllSkills (  );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( deleteAll,response.getBody ().getMessage () );
    }
    @Test
    void testDeleteById()
    {
       Integer id=1;
        ResponseEntity<ResponseDto> response=skillsService.deleteSkillsById ( id );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Skills Record is Deleted Based on skills_Id",response.getBody ().getMessage () );

    }


    @Test
    void testAddUserId() throws UserNotFoundException {
        // Arrange
         String id="dfghjkl";
        Skills skills=mock ( Skills.class );

       User user=mock ( User.class );
        when(userRepository.findById(id)).thenReturn( Optional.of(user));

        // Act
        ResponseEntity<ResponseDto> responseEntity = skillsService.addUserId ( skills,id );

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
@Test
void testUserNOt_found_Exception()
{
    String id="fghjkl;'";
    Skills skills=mock ( Skills.class );

    when ( userRepository.findById ( id ) ).thenReturn ( Optional.empty () );

    assertThrows ( UserNotFoundException.class,()->{skillsService.addUserId ( skills,id );
    } );
}

}
