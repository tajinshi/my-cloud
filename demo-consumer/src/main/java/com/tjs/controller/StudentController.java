package com.tjs.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tjs.bean.Student;
import com.tjs.feign.StudentFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentFeign studentFeign;

    /**
     * 整合hystrix
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getStudentByIdFallBack")
    @GetMapping("getStudentById")
    public Student getStudentById(Long id) {
        log.info("查询student,id为{}",id);
        return studentFeign.getStudentById(id);
    }


    public Student getStudentByIdFallBack (Long id){
        log.info("执行getStudentById的回滚代码id为{}",id);
        return new Student();
    }
}
