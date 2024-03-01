package com.capstone.sample_project.serviceTest;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Department;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.repository.DepartmentRepository;
import com.capstone.sample_project.repository.UserRepository;
import com.capstone.sample_project.service.serviceImpl.UserServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    DepartmentRepository departmentRepository;


    @InjectMocks
    UserServiceImpl userService;

    @Mock
    PasswordEncoder passwordEncoder;




    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
//        ReflectionTestUtils.setField(userService, "passwordEncoder", passwordEncoder);
    }


    @Test
    void testGetAllUser()
    {
        User user=mock(User.class);
        List <User> userList=new ArrayList <> ();
        userList.add ( user );
        when(userRepository.findAll ()).thenReturn(userList);

        ResponseEntity<ResponseDto> response=userService.getAllUsers ();

        assertEquals(HttpStatus.OK,response.getStatusCode ());
        assertEquals("Retrived All Users Successfully!",response.getBody ().getMessage ());
    }
    @Test
     void testSaveUser() {
        // Arrange
        User user = mock ( User.class );
        when ( userRepository.save ( user ) ).thenReturn (user);
        // Act
        ResponseEntity<ResponseDto> response = userService.saveUser(user);

        // Assert

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User Information Saved Successfully", response.getBody().getMessage());
        assertEquals(user, response.getBody().getData());
    }
    @Test
    void testDeleteAll()
    {
        String deleteAll="Deleted All Users";
        ResponseEntity<ResponseDto> response=userService.deleteAllUser (  );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( deleteAll,response.getBody ().getMessage () );
    }
    @Test
    void testDeleteById()
    {
        String id="User Record is Deleted Based on User_Id ";
        ResponseEntity<ResponseDto> response=userService.deleteById ( id );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( id,response.getBody ().getMessage () );

    }


//    @Test
//    void saveDepUser() {
//        // Arrange
//        String depId = null;
//        User existingUser = mock(User.class);
//
//        when(departmentRepository.findById(depId)).thenReturn(Optional.empty());
//
//        // Act
//        ResponseEntity<ResponseDto> responseEntity = userService.saveDepUser(existingUser, depId);
//
//        // Assert
//        assertEquals("DepId is Added In User Table", responseEntity.getBody().getMessage());
//    }

    @Test
    void saveDepUser() {
        // Arrange
        String depId = "deepsi@gmail.com";

        Department department=mock ( Department.class );
        User existingUser = mock(User.class);
        existingUser.setEmail ( existingUser.getEmail () );
        existingUser.setDepartment ( department );
        existingUser.setFirst_name ( existingUser.getFirst_name () );
        existingUser.setLast_name ( existingUser.getLast_name () );
        existingUser.setPassword ( existingUser.getPassword () );

        when ( userRepository.save(existingUser ) ).thenReturn ( existingUser );
        when(departmentRepository.findById(depId)).thenReturn( Optional.ofNullable ( department ) );

        // Act
        ResponseEntity<ResponseDto> responseEntity = userService.saveDepUser(existingUser, depId);

        // Assert
        assertEquals("DepId is Added In User Table", responseEntity.getBody().getMessage());
    }
}
