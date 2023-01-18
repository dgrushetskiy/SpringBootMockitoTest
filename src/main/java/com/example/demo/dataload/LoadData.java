package com.example.demo.dataload;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadData implements ApplicationRunner {

    @Autowired
    StudentRepo repo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repo.save(new Student("Ana", "One"));
        repo.save(new Student("Bob", "Two"));
        repo.save(new Student("Charlie", "One"));
        repo.save(new Student("David", "Three"));
    }
}
