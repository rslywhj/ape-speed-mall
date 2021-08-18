package com.tjetc.user.controller;

import com.google.gson.Gson;
import com.tjetc.user.entity.User;
import com.tjetc.user.service.UserService;
import com.tjetc.user.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/updatePassword"})
public class UpdatePssswordServlet extends HttpServlet {
     UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");
        Long user_id = user.getId();
        String password = user.getPassword();
        boolean b = userService.resPassword(user_id,password);
        Gson gson = new Gson();
        String s = gson.toJson(b);
        resp.getWriter().write(s);
    }
}
