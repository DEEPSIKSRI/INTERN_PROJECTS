package com.capstone.sample_project.controllerTest;

import com.capstone.sample_project.controller.SkillsController;
import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Skills;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import com.capstone.sample_project.repository.UserRepository;
import com.capstone.sample_project.service.serviceImpl.SkillsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SkillsControllerTest {


    @BeforeEach
    void setUp ( ) {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    SkillsServiceImpl skillsService;


    @Mock
    UserRepository userRepository;


    @InjectMocks
    SkillsController skillsController;

    @Test
    void testGetAllSkills() throws Exception {
       Skills skills=mock ( Skills.class );
        List<Skills> skillsList = Collections.singletonList(skills);
        ResponseEntity<ResponseDto> responseEntity = ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK, "Retrived All the Skills", skillsList));

        when(skillsService.getSkills ()).thenReturn(responseEntity);

        ResponseEntity<ResponseDto> response=skillsController.getAllSkills ();
        assertEquals(HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Retrived All the Skills",response.getBody ().getMessage () );
    }
    @Test
    void testSaveSkills()
    {
        Skills skills=mock ( Skills.class );
        when ( skillsService.addSkills ( skills ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"Skills are Saved Successfully!",skills ) ) );

        ResponseEntity<ResponseDto> response=skillsController.addSkills ( skills );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Skills are Saved Successfully!",response.getBody ().getMessage () );
    }

    @Test
    void testDeleteAll()
    {
        Skills skills=mock ( Skills.class );
        when ( skillsService.deleteAllSkills (  ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"Skills Record is Deleted",null ) ) );

        ResponseEntity<ResponseDto> response=skillsController.deleteAllSkills (  );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Skills Record is Deleted",response.getBody ().getMessage () );
    }
    @Test
    void testDeleteById()
    {
        Integer id=1;
        when ( skillsService.deleteSkillsById ( id ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Skills Record is Deleted Based on skills_Id",null) ) );

        ResponseEntity<ResponseDto> response=skillsController.deleteSkillsById ( id );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Skills Record is Deleted Based on skills_Id",response.getBody ().getMessage () );

    }

    @Test
    void testAddUserId() throws UserNotFoundException {
        Skills skills=mock ( Skills.class );
        String id="rtyuio";
        when ( skillsService.addUserId ( skills,id ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"UserId are Saved in Skills Information Successfully!",skills ) ) );

        ResponseEntity<ResponseDto> response=skillsController.addUserId (skills,id );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "UserId are Saved in Skills Information Successfully!",response.getBody ().getMessage () );

    }


}
