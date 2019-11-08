package com.cmz.delegate.mvc;


import com.cmz.delegate.mvc.controller.MemberController;
import com.cmz.delegate.mvc.controller.OrderController;
import com.cmz.delegate.mvc.controller.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1、获取用户请求的url
        //   如果按照J2EE的标准、每个url对对应一个Serlvet，url由浏览器输入
        String uri = request.getRequestURI();
        //2、Servlet拿到url以后，要做权衡（要做判断，要做选择）
        String mid = request.getParameter("mid");

        if("getMemberById".equals(uri)){
            new MemberController().getMemberById(mid);
        }else if("getOrderById".equals(uri)){
            new OrderController().getOrderById(mid);
        }else if("logout".equals(uri)){
            new SystemController().logout();
        }else {
            response.getWriter().write("404 Not Found!!");
        }
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
