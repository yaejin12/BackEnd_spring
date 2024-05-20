package com.study.springstudy.springmvc;

import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor//기본생성자
@AllArgsConstructor//모든 필드 초기화 생성자
//@RequiredArgsConstructor //필수 파라미터(final 필드) 초기화 생성자

@Setter
@Getter
@ToString
public class Student {
    private  String name;
    private int age;
    private int grade;
}
