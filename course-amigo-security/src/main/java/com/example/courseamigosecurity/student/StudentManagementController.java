package com.example.courseamigosecurity.student;

import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getSTUDENTS() {
        System.out.println("GetAll method");
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(Student student){
        System.out.println("PostMethod");
    }

    @DeleteMapping(path = "/{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println("DelMethod " + studentId);
    }

    @PutMapping(path = "/{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId,  Student student){
        System.out.println("UpdateMethod " + studentId);
    }
}
