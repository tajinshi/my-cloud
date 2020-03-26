package com.tjs.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private Long pid;
    private String name;
    private int age;
}
