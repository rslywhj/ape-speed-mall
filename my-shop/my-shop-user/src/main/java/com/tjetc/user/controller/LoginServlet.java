package com.tjetc.user.controller;


import com.tjetc.user.entity.User;
import com.tjetc.user.service.UserService;
import com.tjetc.user.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //3、获取username和password参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean remember = Boolean.parseBoolean(req.getParameter("remember"));
        //4、调用service.findByUsernameAndPassword方法传入参数（username，password），检查是否可以登陆
        User user = userService.findByUsernameAndPassword(username, password);
        //5、返回json数据格式（因为前端使用ajax技术，所以后端不能跳转）
        //判断user是否为null，为null表示不存在对应用户名密码，不为null说明查找到用户，把用户信息存储到session中，返回登陆成功
        //但不要跳转，跳转页面交给前端，后端只负责提供数据
        if (user!=null){
            if (remember){
                //把user存到session中
                req.getSession().setAttribute("user",user);
            }else {
                req.getSession().setAttribute("password",null);
            }
            req.getSession().setAttribute("user",user);
            System.out.println("user = " + user);
            resp.getWriter().write("true");
        }else {
            resp.getWriter().write("false");
        }
    }
}

