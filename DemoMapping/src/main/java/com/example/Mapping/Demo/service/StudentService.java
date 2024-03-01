package com.example.Mapping.Demo.service;

import com.example.Mapping.Demo.controller.AuthentictaionResponse;
import com.example.Mapping.Demo.entity.Employee;
import com.example.Mapping.Demo.entity.Project;
import com.example.Mapping.Demo.entity.Student;
import com.example.Mapping.Demo.exception.ResourceNotFoundException;
import com.example.Mapping.Demo.repository.ProjectRepository;
import com.example.Mapping.Demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProjectRepository projectRepository;

    public List<Student> getDetails() {
        return studentRepository.findAll();

    }

    public List<Project> getProject() {
        return projectRepository.findAll();
    }

    public Student getStudProj(Integer Stud_id, Integer Proj_id) {
        Set<Project> projectSet = null;
        Student student = studentRepository.findById(Stud_id).get();
        Project project = projectRepository.findById(Proj_id).get();
        projectSet = student.getProjects();
        projectSet.add(project);
        student.setProjects(projectSet);
        return studentRepository.save(student);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public String deleteAll(Integer studId) {
        studentRepository.deleteById(studId);
        return "Successfully Deleted";
    }

    public String deleteProject(Integer projId) {
        projectRepository.deleteById(projId);
        return "Successfully Deleted";
    }


    public Student storeProj(Integer studId, Project project) {
        Set<Project> studentSet = null;
        Optional<Student> optionalStudent = studentRepository.findById(studId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            Project project1 = projectRepository.save(project);
            studentSet = student.getProjects();
            studentSet.add(project1);
            student.setProjects(studentSet);
            return studentRepository.save(student);
        }
        return null;
    }

    public Project updateProject(Project project,Integer Proj_Id) {
        Project oldProject=projectRepository.findById(Proj_Id).orElseThrow(()->new ResourceNotFoundException("Project Not Found"));
        oldProject.setProj_id(project.getProj_id());
        oldProject.setProj_name(project.getProj_name());
        return projectRepository.save(oldProject);
    }

    public Student updateStudent(Student student, Integer studId) {
        Student oldStudent=studentRepository.findById(studId).orElseThrow(()-> new ResourceNotFoundException("Students not there"));
        oldStudent.setStud_id(student.getStud_id());
        oldStudent.setStud_name(student.getStud_name());
        oldStudent.setProjects(student.getProjects());
        return studentRepository.save(oldStudent);
    }


    public String deleteEmployee ( ) {
        studentRepository.deleteAll ();
        return "Successfully deleted";

    }
}




