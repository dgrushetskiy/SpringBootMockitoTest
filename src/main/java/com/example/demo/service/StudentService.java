package com.example.demo.service;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    public Iterable<Student> findAll(){
        return repo.findAll();
    }

    public Optional<Student> findById(Long id) {
        return repo.findById(id);
    }

    public Student save(Student newStudent) {
        return repo.save(newStudent);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
