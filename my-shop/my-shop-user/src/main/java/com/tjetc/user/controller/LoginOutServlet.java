package com.tjetc.user.controller;


import com.tjetc.user.service.UserService;
import com.tjetc.user.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/login_out"})
public class LoginOutServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("refresh", "2;URL=admin_login.jsp");
        System.out.println(1);
        req.getSession().setAttribute("user",null);
        req.getSession().removeAttribute("user");
        resp.getWriter().write("true");
    }
}

