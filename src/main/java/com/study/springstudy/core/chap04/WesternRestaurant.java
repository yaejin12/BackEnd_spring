package com.study.springstudy.core.chap04;

import org.springframework.stereotype.Component;

@Component("wwww")
public class WesternRestaurant implements Restaurant {
    //담당 셰프
    private Chef chef;

    //요리 코스
    private Course course;

    //생성자
    public WesternRestaurant(Chef chef, Course course) {
        this.chef = chef;
        this.course = course;
    }

    //주문기능
    public void order(){
        System.out.println("서양 요리를 주문합니다.");
        course.combineMenu();
        chef.cook();
    }
}
