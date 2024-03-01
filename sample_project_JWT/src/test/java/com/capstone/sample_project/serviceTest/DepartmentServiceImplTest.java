package com.capstone.sample_project.serviceTest;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Department;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.repository.DepartmentRepository;
import com.capstone.sample_project.service.serviceImpl.DepartmentServiceImpl;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DepartmentServiceImplTest {

    @Mock
    DepartmentRepository departmentRepository;

    @InjectMocks
    DepartmentServiceImpl departmentService;

    @BeforeEach
    void setUp ( ) {
        MockitoAnnotations.openMocks ( this );
    }

//    @Test
//    void testGetDep()
//    {
//
//        Department department=mock ( Department.class );
//        List <Department> departments=new ArrayList <> ();
//        departments.add ( department );
//        when(departmentRepository.findAll ()).thenReturn(departments);
//        ResponseEntity < ResponseDto > response=departmentService.getAllDep ();
//        assertEquals(HttpStatus.OK,response.getStatusCode () );
//        assertEquals ( "Retrived All the Departments Successfully",response.getBody ().getMessage () );
//    }
    @Test
    void testSaveDep()
    {
        Department department=mock ( Department.class );
        when ( departmentRepository.save ( department ) ).thenReturn ( department );

        ResponseEntity<ResponseDto> response=departmentService.saveDep ( department );


        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Departments Information are Saved Successfully",response.getBody ().getMessage () );
    }
    @Test
    void testSaveDepUser()
    {
        Department department=mock ( Department.class );
        User user=mock ( User.class );
        user.setDepartment ( department );

        when ( departmentRepository.save ( department ) ).thenReturn ( department );

        ResponseEntity<ResponseDto> response=departmentService.saveDepUser ( department );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Dep is Saved in User Table!",response.getBody ().getMessage () );
    }

    @Test
    void testDeleteAll()
    {

        ResponseEntity<ResponseDto> response=departmentService.deleteAllDep (  );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Department Deleted",response.getBody ().getMessage () );
    }
    @Test
    void testDeleteById()
    {
        String id="1";
        Department department=mock ( Department.class );
        when ( departmentRepository.findById ( id ) ).thenReturn ( Optional.of ( department ) );

        ResponseEntity<ResponseDto> response=departmentService.deleteById ( id );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Department Deleted Based on Dep_Id",response.getBody ().getMessage () );
    }
    @Test
    void testDeleteById_NotFound()
    {
        String id="1";
//        Department department=mock ( Department.class );
        when ( departmentRepository.findById ( id ) ).thenReturn ( Optional.empty ());

        ResponseEntity<ResponseDto> response=departmentService.deleteById ( id );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Department not found with Dep_Id: "+id,response.getBody ().getMessage () );
    }
}