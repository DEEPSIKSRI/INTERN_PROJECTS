package com.capstone.sample_project.controller;

import com.capstone.sample_project.api.DepartmentApi;
import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Department;
import com.capstone.sample_project.service.serviceImpl.DepartmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController  implements DepartmentApi {

    @Autowired
    DepartmentServiceImpl departmentService;

    @Override
    public ResponseEntity < ResponseDto > getAllDep (String token ) {
        log.info ("getDept" + token);
        return departmentService.getAllDep(token);
    }

    @Override
    public ResponseEntity < ResponseDto > saveDep (@RequestBody Department department ) {
//        department.
        System.out.println (department+"  hello" );
        return departmentService.saveDep ( department );
    }

    @Override
    public ResponseEntity < ResponseDto >  deleteId ( String depId ) {
        return departmentService.deleteById(depId);
    }

    @Override
    public ResponseEntity < ResponseDto > deleteAllDep ( ) {
        return departmentService.deleteAllDep();
    }

//    @Override
//    public Department saveDepUser ( @RequestBody Department department ) {
//        return departmentService.saveDepUser(department);
//    }
}
