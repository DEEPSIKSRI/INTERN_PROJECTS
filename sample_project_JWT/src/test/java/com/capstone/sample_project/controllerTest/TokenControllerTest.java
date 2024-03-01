package com.capstone.sample_project.controllerTest;

import com.capstone.sample_project.controller.TokenController;
import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.service.serviceImpl.TokenServiceImpl;
import jakarta.persistence.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TokenControllerTest {

    @Mock
    TokenServiceImpl tokenService;
    @InjectMocks
    TokenController tokenController;

    @BeforeEach
    void setUp ( ) {
        MockitoAnnotations.openMocks ( this );
    }

    @Test
    void testRegister()
    {
        User user=mock ( User.class );
        when ( tokenService.register ( user ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"User Information Saved Successfully",user ) ) );

        ResponseEntity<ResponseDto> response=tokenController.register ( user );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "User Information Saved Successfully",response.getBody ().getMessage () );
    }
@Test
    void testLogout()
{
    User user=mock ( User.class );
    when ( tokenService.logout ( user.getEmail () ) ).thenReturn (  ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"User not found",null))  );

    ResponseEntity<ResponseDto> response=tokenController.logout ( user.getEmail () );

    assertEquals ( HttpStatus.OK,response.getStatusCode () );
    assertEquals ( "User not found",response.getBody ().getMessage () );
}
@Test
    void testLogin()
{
    User user=mock ( User.class );
    when ( tokenService.loginSecurity ( user) ).thenReturn (  ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"Authorized User are Logged in!",null))  );

    ResponseEntity<ResponseDto> response=tokenController.login ( user );

    assertEquals ( HttpStatus.OK,response.getStatusCode () );
    assertEquals ( "Authorized User are Logged in!",response.getBody ().getMessage () );

}
}
