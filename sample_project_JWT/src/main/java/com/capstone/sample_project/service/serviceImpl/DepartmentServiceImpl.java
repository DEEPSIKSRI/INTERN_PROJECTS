package com.capstone.sample_project.service.serviceImpl;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Department;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.repository.DepartmentRepository;
import com.capstone.sample_project.service.DepartmentService;
import com.capstone.sample_project.tokenService.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    TokenServiceImpl tokenService;

    @Autowired
    JwtService jwtService;

    
    @Override
    public ResponseEntity<ResponseDto> getAllDep(String token) {
        List < Department > departments = departmentRepository.findAll ( );
        return ResponseEntity.status ( HttpStatus.OK )
                .body ( new ResponseDto ( HttpStatus.OK , "Retrieved All the Departments Successfully" , departments ) );
    }
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(new ResponseDto(HttpStatus.UNAUTHORIZED, "Unauthorized Users are not allowed to access this resource", null));
//        }


    @Override
    public ResponseEntity < ResponseDto > saveDep (Department department ) {
//        System.out.println (department+"  hai" );
         departmentRepository.save (  department);
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Departments Information are Saved Successfully",department) );

    }

    @Override
    public ResponseEntity < ResponseDto > deleteById(String depId) {
        Optional <Department> departmentOptional = departmentRepository.findById(depId);
        if (departmentOptional.isPresent()) {
            departmentRepository.deleteById(depId);

            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Department Deleted Based on Dep_Id",null) );
        } else {
            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Department not found with Dep_Id: " + depId,depId) );

        }
    }

    @Override
    public ResponseEntity < ResponseDto > saveDepUser ( Department department ) {
            department.setDepId (department.getDepId () );
            department.setDepName ( department.getDepName () );

            User user=new User (  );
            user.setEmail (user.getEmail () );
            user.setFirst_name ( user.getFirst_name () );
            user.setLast_name ( user.getLast_name () );
            user.setDepartment ( user.getDepartment () );
            departmentRepository.save ( department );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Dep is Saved in User Table!",department) );

    }

    @Override
    public ResponseEntity < ResponseDto > deleteAllDep ( )
    {
        departmentRepository.deleteAll ();
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Department Deleted",null) );

    }
}
