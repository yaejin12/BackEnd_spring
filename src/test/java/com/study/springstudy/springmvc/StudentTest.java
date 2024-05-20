package com.study.springstudy.springmvc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void sTest(){
        Student student = new Student();
        student.getAge();
        student.setAge(20);
        student.setGrade(30);
        student.toString();
    }

}