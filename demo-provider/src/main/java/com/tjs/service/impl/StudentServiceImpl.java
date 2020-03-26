package com.tjs.service.impl;

import com.tjs.bean.Student;
import com.tjs.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public Student getStudentById(Long id) {
        log.info("查询学生Id为:{}",id);
        //查询数据库操作
        Student stu = new Student(id,"张三",22);
        return stu;
    }
}
