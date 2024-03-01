package com.capstone.sample_project.controllerTest;

import com.capstone.sample_project.controller.UserController;
import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.service.serviceImpl.UserServiceImpl;
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

public class UserControllerTest {


    @BeforeEach
    void setUp ( ) {
        MockitoAnnotations.openMocks ( this );
    }

    @Mock
    UserServiceImpl userService;

    @InjectMocks
    UserController userController;

    @Test
    void testGetAllUsers ( ) throws Exception {
        User user = mock ( User.class );
        List < User > userList = Collections.singletonList ( user );
        ResponseEntity < ResponseDto > responseEntity = ResponseEntity.status ( HttpStatus.OK )
                .body ( new ResponseDto ( HttpStatus.OK , "Retrieved All Users Successfully!" , userList ) );

        when ( userService.getAllUsers ( ) ).thenReturn ( responseEntity );

        ResponseEntity < ResponseDto > response = userController.getAllUser ( );
        assertEquals ( HttpStatus.OK , response.getStatusCode ( ) );
        assertEquals ( "Retrieved All Users Successfully!" , response.getBody ( ).getMessage ( ) );
    }

    @Test
    void testSaveUser()
    {
        User user=mock ( User.class );
        when ( userService.saveUser ( user ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"User Information Saved Successfully",user ) ) );

        ResponseEntity<ResponseDto> response=userController.saveUser ( user );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "User Information Saved Successfully",response.getBody ().getMessage () );
    }

    @Test
    void testDeleteAll()
    {
        User user=mock ( User.class );
        when ( userService.deleteAllUser (  ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"Deleted All Users",null ) ) );

        ResponseEntity<ResponseDto> response=userController.deleteAllUser (  );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Deleted All Users",response.getBody ().getMessage () );
    }
    @Test
    void testDeleteById()
    {
        String id="1hjkl;";
        when ( userService.deleteById ( id ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"User Record is Deleted Based on User_Id ",null) ) );

        ResponseEntity<ResponseDto> response=userController.deleteById ( id );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "User Record is Deleted Based on User_Id ",response.getBody ().getMessage () );

    }

    @Test
    void testSaveDepInUser()
    {
        User user=mock ( User.class );
        String depId="1";
        when ( userService.saveDepUser ( user,depId ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"DepId is Added In User Table",user ) ) );

        ResponseEntity<ResponseDto> response=userController.saveDepInUser (user, depId );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "DepId is Added In User Table",response.getBody ().getMessage () );

    }


}
