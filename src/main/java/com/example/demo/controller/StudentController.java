package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    private List<Student> getAllStudents(){
        return (List<Student>) service.findAll();
    }

    @GetMapping("/student/{id}")
    private Optional<Student> getStudents(@PathVariable Long id){
        return  service.findById(id);
    }

    @PostMapping("/students")
    private Student addStudent(@RequestBody Student newStudent){
        return service.save(newStudent);
    }

    @DeleteMapping("/students/{id}")
    private void removeStudent(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping("/students/{id}")
    private Student updateStudent(@RequestBody Student newStudent, @PathVariable Long id){
        return service.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setGrade(newStudent.getGrade());
                    return service.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setStudent_id(Math.toIntExact(id));
                    return service.save(newStudent);
                });
    }
}
