package com.capstone.sample_project.service;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    ResponseEntity < ResponseDto > getAllDep(String token);

    ResponseEntity < ResponseDto > saveDep(Department department);

    ResponseEntity < ResponseDto > deleteById ( String depId );


    ResponseEntity < ResponseDto > saveDepUser ( Department department );

    ResponseEntity < ResponseDto > deleteAllDep ( );
}
