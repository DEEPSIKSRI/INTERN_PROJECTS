package com.capstone.sample_project.controllerTest;

import com.capstone.sample_project.controller.DepartmentController;
import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Department;
import com.capstone.sample_project.service.serviceImpl.DepartmentServiceImpl;
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

public class DepartmentControllerTest {
    @Mock
    DepartmentServiceImpl departmentService;

    @InjectMocks
    DepartmentController departmentController;

    @BeforeEach
    void setUp ( ) {
        MockitoAnnotations.openMocks ( this );
    }

//
//    @Test
//    void testGetAllDep() throws Exception {
//        Department department=mock ( Department.class );
//        List <Department> departmentList = Collections.singletonList(department);
//        ResponseEntity < ResponseDto > responseEntity = ResponseEntity.status( HttpStatus.OK)
//                .body(new ResponseDto(HttpStatus.OK, "Retrived All the Departments Successfully", departmentList));
//
//        when(departmentService.getAllDep ()).thenReturn(responseEntity);
//
//        ResponseEntity<ResponseDto> response=departmentController.getAllDep ();
//        assertEquals(HttpStatus.OK,response.getStatusCode () );
//        assertEquals ( "Retrived All the Departments Successfully",response.getBody ().getMessage () );
//    }
    @Test
    void testSaveDep()
    {
        Department department=mock ( Department.class );
        when ( departmentService.saveDep ( department ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"Saved All the Address Successfully!!",department ) ) );

        ResponseEntity<ResponseDto> response=departmentController.saveDep ( department );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Saved All the Address Successfully!!",response.getBody ().getMessage () );
    }

    @Test
    void testDeleteAll()
    {
//        Department department=mock ( Department.class );
        when ( departmentService.deleteAllDep (  ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto ( HttpStatus.OK,"Department Deleted",null ) ) );

        ResponseEntity<ResponseDto> response=departmentController.deleteAllDep (  );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Department Deleted",response.getBody ().getMessage () );
    }
    @Test
    void testDeleteById()
    {
        String id="1";
        when ( departmentService.deleteById ( id ) ).thenReturn ( ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Department Deleted Based on Dep_Id",null) ) );

        ResponseEntity<ResponseDto> response=departmentController.deleteId ( id );

        assertEquals ( HttpStatus.OK,response.getStatusCode () );
        assertEquals ( "Department Deleted Based on Dep_Id",response.getBody ().getMessage () );

    }
}


