package com.example.Mapping.Demo.Controller;

import com.example.Mapping.Demo.Entity.Project;
import com.example.Mapping.Demo.Entity.Student;
import com.example.Mapping.Demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("studentProject")
public class StudProjController {

    @Autowired
    StudentService studentService;

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


}
