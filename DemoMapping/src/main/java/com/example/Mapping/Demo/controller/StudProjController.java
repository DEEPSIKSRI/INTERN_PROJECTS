package com.example.Mapping.Demo.controller;

import com.example.Mapping.Demo.entity.Project;
import com.example.Mapping.Demo.entity.RegisterRequest;
import com.example.Mapping.Demo.entity.Student;
import com.example.Mapping.Demo.service.RegisterService;
import com.example.Mapping.Demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/security")
public class StudProjController {

    @Autowired
    StudentService studentService;

    @Autowired
    RegisterService registerService;

    @GetMapping("/get")
    public List<Student> getStudent() {

        return studentService.getDetails();
    }

    @GetMapping("/getProject")
    public List<Project> getProject() {
        return studentService.getProject();
    }

    @GetMapping("/getStudProj/{Proj_id}/{Stud_id}")
    public Student getStudProj(@PathVariable(value = "Stud_id") Integer Stud_id,
                               @PathVariable(value = "Proj_id") Integer Proj_id) {
        return studentService.getStudProj(Stud_id, Proj_id);
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PostMapping("/saveProject")
    public Project saveProject(@RequestBody Project project) {
        return studentService.saveProject(project);
    }

    @DeleteMapping("/deleteByStudId/{Stud_id}")
    public String deleteAll(@PathVariable(value = "Stud_id") Integer Stud_id) {
        return studentService.deleteAll(Stud_id);
    }

    @DeleteMapping("/deleteByProjId/{Proj_id}")
    public String deleteProject(@PathVariable(value = "Proj_id") Integer Proj_id) {
        return studentService.deleteProject(Proj_id);
    }

    @PostMapping("/storeProject/{Stud_id}")
    public Student storeStudent(@PathVariable(value = "Stud_id") Integer stud_id,
                                @RequestBody Project project) {
        return studentService.storeProj(stud_id, project);
    }


    @PutMapping("/editProject/{Proj_id}")
    public Project updateProject(@RequestBody Project project,
                                 @PathVariable(value = "Proj_id") Integer Proj_id) {
        return studentService.updateProject(project, Proj_id);
    }

    @PutMapping("/editStudent/{Stud_id}")
    public Student updateStudent(@PathVariable(value = "Stud_id") Integer Stud_id,
                                 @RequestBody Student student) {
        return studentService.updateStudent(student, Stud_id);
    }

//security

    @PostMapping("/register")
    public ResponseEntity<AuthentictaionResponse> register(@RequestBody RegisterRequest request)
    {

        System.out.println(request.getPassword() + "<-------------");
        System.out.println(request.getEmail() + "<-------------");
        return ResponseEntity.ok(registerService.registers(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthentictaionResponse> authenticate(
            @RequestBody AuthenticateRequest request)
    {
        System.out.println(request.getEmail() + "<-------------");
        return ResponseEntity.ok(registerService.authenticate(request));

    }
    @DeleteMapping("/deleteEmployee")
    public String delete()
    {
        return studentService.deleteEmployee();
    }

}
