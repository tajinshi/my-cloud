package com.tjs.service;

import com.tjs.bean.Student;

public interface StudentService {
    /**
     * 获取学生用户
     * @param id 学生id
     * @return
     */
    Student getStudentById(Long id);
}
