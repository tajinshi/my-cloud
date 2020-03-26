package com.tjs.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private Long pid;
    private String name;
    private int age;

    public Student(Long pid, String name, int age) {
        this.pid = pid;
        this.name = name;
        this.age = age;
    }
}
