package com.capstone.sample_project.api;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/department")
public interface DepartmentApi {

    @GetMapping("/getAllDepartment")
    ResponseEntity < ResponseDto > getAllDep(@RequestHeader("Authorization") String token);

    @PostMapping("/saveDep")
    ResponseEntity < ResponseDto > saveDep(@RequestBody Department department);

    @DeleteMapping("/deleteId/{depId}")
    ResponseEntity < ResponseDto > deleteId(@PathVariable (value="depId") String depId);

    @DeleteMapping("/deleteAllDep")
    ResponseEntity < ResponseDto > deleteAllDep();

}
