package com.example.JWT.JWT.serviceTest;


import com.example.JWT.JWT.model.JwtModel;
import com.example.JWT.JWT.model.Role;
import com.example.JWT.JWT.repository.UserRepository;
import com.example.JWT.JWT.service.TokenService;
import io.jsonwebtoken.Jwt;
import org.apache.tomcat.Jar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TokenServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    TokenService tokenService;


    @Test
    void testGetRecord() {
        JwtModel jwtModel = new JwtModel(1, "deepsi@gmail.com", "Deepsi", "R", "123", Role.USER);
        List<JwtModel> jwtModels = new ArrayList<>();
        jwtModels.add(jwtModel);
        when(userRepository.findAll()).thenReturn(jwtModels);

        List<JwtModel> jwtModels1 = tokenService.recordGet();

        assertEquals(jwtModels, jwtModels1);
    }

    @Test
    void testRecordSave() {
        JwtModel jwtModel = new JwtModel(1, "deepsi@gmail.com", "Deepsi", "R", "123", Role.USER);
        when(userRepository.save(jwtModel)).thenReturn(jwtModel);
        System.out.println("Expected:--- " + jwtModel);

        JwtModel jwtModel1 = tokenService.recordSave(jwtModel);
        System.out.println("Actual: " + jwtModel1);
        assertEquals(jwtModel, jwtModel1);
    }

    @Test
    void testUpdateUserRecord() {
        Integer userId = 1;

        JwtModel existingUser = new JwtModel(1, "deepsi@gmail.com", "deepsi", "r", "123", Role.USER);
        JwtModel updatedUser = new JwtModel(1, "new@gmail.com", "New", "n", "new", Role.ADMIN);
        when(userRepository.findById(userId)).thenReturn(Optional.of((existingUser)));
        when(tokenService.recordUpdate(userId, updatedUser)).thenReturn(updatedUser);

        JwtModel result = tokenService.recordUpdate(userId, updatedUser);

        // Assert
        assertNotNull(result);
        assertEquals(updatedUser.getUser_id(), result.getUser_id());
        assertEquals(updatedUser.getEmail(), result.getEmail());
        assertEquals(updatedUser.getFirstName(), result.getFirstName());
        assertEquals(updatedUser.getLastName(), result.getLastName());
        assertEquals(updatedUser.getPassword(), result.getPassword());
        assertEquals(updatedUser.getRole(), result.getRole());

    }
@Test
    void testDeleteById()
{
    Integer id=1;
    willDoNothing().given(userRepository).deleteById(id);
    tokenService.recordDelete(id);
    verify(userRepository,times(1)).deleteById(id);
}

@Test
    void testDeleteAll()
{
  String expected="Deleted All Records";
  String actual=tokenService.deleteAll();
  assertEquals(expected,actual);
}
}

