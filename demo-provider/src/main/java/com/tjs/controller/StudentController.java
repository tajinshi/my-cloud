package com.tjs.controller;

import com.tjs.bean.Student;
import com.tjs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = "getStudentById")
    public Student getStudentById(Long id) {
        Student stu = studentService.getStudentById(id);
        return stu;
    }
}
