package com.capstone.sample_project.serviceTest;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Role;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.repository.UserRepository;
import com.capstone.sample_project.service.serviceImpl.TokenServiceImpl;
import com.capstone.sample_project.tokenService.JwtService;
import jakarta.persistence.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TokenServiceTest {
    @InjectMocks
    TokenServiceImpl tokenService;

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    JwtService jwtService;

    @BeforeEach
    void setUp ( ) {
        MockitoAnnotations.openMocks ( this );
    }
    @Test
    void testAdmin() {
        User user = new User ( );
        user.setEmail ( "deepsi" );
        user.setRole ( Role.valueOf ( "ADMIN" ) );
        user.setPassword ( passwordEncoder.encode ( "password" ) );

        when ( userRepository.findByEmail ( user.getEmail ( ) ) ).thenReturn ( user );
        when ( jwtService.generateToken ( user.getEmail ( ) , user.getRole ( ) ) ).thenReturn ( "token" );
        when ( userRepository.save ( user ) ).thenReturn ( user );

        ResponseEntity < ResponseDto > response = tokenService.loginSecurity ( user );

        assertEquals ( HttpStatus.OK , response.getStatusCode ( ) );
        assertEquals ( "Authorized Admins are logged in!!" , response.getBody ( ).getMessage ( ) );
        assertEquals ( "token" , user.getToken ( ) );
    }
    @Test
    void testUser() {
        User user = new User ( );
        user.setEmail ( "deepsi" );
        user.setRole ( Role.valueOf ( "USER" ) );
        user.setPassword ( passwordEncoder.encode ( "password" ) );

        when ( userRepository.findByEmail ( user.getEmail ( ) ) ).thenReturn ( user );
        when ( jwtService.generateToken ( user.getEmail ( ) , user.getRole ( ) ) ).thenReturn ( "token" );
        when ( userRepository.save ( user ) ).thenReturn ( user );

        ResponseEntity < ResponseDto > response = tokenService.loginSecurity ( user );

        assertEquals ( HttpStatus.OK , response.getStatusCode ( ) );
        assertEquals ( "Authorized User are Logged in!!" , response.getBody ( ).getMessage ( ) );
        assertEquals ( "token" , user.getToken ( ) );
    }

    @Test
    void testUnauthorizedRole() {
        User user = new User ( );
        user.setFirst_name ( "abe" );
        user.setLast_name ( "D" );
//        user.setRole ( Role.valueOf ( "ROLe" ) );
        user.setEmail ( "abc@example.com");
        user.setPassword ( passwordEncoder.encode ( "password" ) );

        when ( userRepository.findByEmail ( user.getEmail ( ) ) ).thenReturn ( user );

        ResponseEntity < ResponseDto > response = tokenService.loginSecurity ( user );

        assertEquals ( HttpStatus.BAD_REQUEST , response.getStatusCode ( ) );
        assertEquals ( "Unauthorized: Only users are allowed to log in" , response.getBody ( ).getMessage ( ) );
    }
    @Test
    void testRegister()
    {
        User user=mock ( User.class );

        when ( userRepository.save ( user ) ).thenReturn ( user );

        ResponseEntity<ResponseDto> response=tokenService.register ( user );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "User Information Saved Successfully",response.getBody ().getMessage ());
    }



    @Test
    void testLogout()
    {
        User user=mock ( User.class );
        String userEmail="deepsi@gmail.com";
        when ( userRepository.findByEmail ( userEmail ) ).thenReturn ( user );

        ResponseEntity<ResponseDto> response=tokenService.logout ( userEmail );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "User logged out successfully",response.getBody ().getMessage () );
    }

    @Test
    void testUserNotFound()
    {
        User user=mock ( User.class );
        String userEmail="userNotFound";
        when ( userRepository.findByEmail ( userEmail ) ).thenReturn (null );

        ResponseEntity<ResponseDto> response=tokenService.logout ( userEmail );

        assertEquals ( HttpStatus.BAD_REQUEST,response.getStatusCode () );
        assertEquals ( "User not found",response.getBody ().getMessage () );
    }



















    }
