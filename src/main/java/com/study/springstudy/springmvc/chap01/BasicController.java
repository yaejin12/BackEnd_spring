package com.study.springstudy.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/spring/chap01/*")
public class BasicController {

    //디테일한 요청
    //URL : /spring/chap01/
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello 요청이 들어옴!");
        return "hello";
    }

    //요청 파라미터(Query String) 읽기
    //URL에 붙어있거나 form태그에서 전송된 데이터

    //1. 원초적인 방식
    @RequestMapping("/person")
    public String person(HttpServletRequest request) {
        System.out.println("/parson");
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        System.out.println("age = " + age);
        System.out.println("name = " + name);
        return "";
    }

    //2. @RequestParam 사용하기
    @RequestMapping("/major")
    public String major(@RequestParam String stu, @RequestParam String major, @RequestParam int grade) {
        System.out.println("stu = " + stu);
        System.out.println("major = " + major);
        System.out.println("grade = " + grade);
        return "";
    }

    //3. 커멘드 객체(Request DTO) 사용하기
    @RequestMapping("/order")
    public String order(OrderDto order) {
        System.out.println("order = " + order.getOrderNum());
        System.out.println("Goods = " + order.getGoods());
        System.out.println("Amount = " + order.getAmount());
        System.out.println("Price = " + order.getPrice());
        return "";
    }


}
