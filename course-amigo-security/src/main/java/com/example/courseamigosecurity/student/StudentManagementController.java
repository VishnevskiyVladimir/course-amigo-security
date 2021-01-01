package com.example.courseamigosecurity.student;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  java.util.List;

/**
 * @author Vladimir Vishnevskiy
 */

@RestController
@RequestMapping(path = "management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = List.of(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping
    public List<Student> getSTUDENTS() {
        System.out.println("GetAll method");
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent(Student student){
        System.out.println("PostMethod");
    }

    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println("DelMethod " + studentId);
    }

    @PutMapping(path = "/{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId,  Student student){
        System.out.println("UpdateMethod " + studentId);
    }
}
