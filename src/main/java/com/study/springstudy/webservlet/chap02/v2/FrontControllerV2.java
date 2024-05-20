package com.study.springstudy.webservlet.chap02.v2;


import com.study.springstudy.webservlet.View;
import com.study.springstudy.webservlet.chap02.v2.controller.ControllerV2;
import com.study.springstudy.webservlet.chap02.v2.controller.JoinController;
import com.study.springstudy.webservlet.chap02.v2.controller.SaveController;
import com.study.springstudy.webservlet.chap02.v2.controller.ShowController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//브라우저의 /chap02/V1/~ 시작하는 요청을 처리하는 서블릿
@WebServlet("/chap02/v2/*")
public class FrontControllerV2 extends HttpServlet {
    /*
    * /chap02/V1/join : 회원가입 화면열기 요청
    * /chap02/V1/save : 회원정보 등록 요청
    * /chap02/V1/show : 회원리스트 조회 요청
    * */

    //key:요청 URI, value:
    private Map<String, ControllerV2> controllerV1Map = new HashMap<>();

    public FrontControllerV2(){
        controllerV1Map.put("/chap02/v2/Join",new JoinController());
        controllerV1Map.put("/chap02/v2/Save",new SaveController());
        controllerV1Map.put("/chap02/v2/Show",new ShowController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("브라우저 요청이 들어옴");

        //들어온 요청 구분하기
        String uri = req.getRequestURI();
        System.out.println("요청 uri = " + uri);

        //요청에 맞는 적당한 컨트롤러 객체를 맵에서 꺼내기
        ControllerV2 controller = controllerV1Map.get(uri);

        controller.process(req,resp);
        View view = controller.process(req, resp);
        view.render(req, resp);
    }
}
