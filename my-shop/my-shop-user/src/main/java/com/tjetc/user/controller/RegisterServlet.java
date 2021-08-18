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

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
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
		User user = userService.findByUsernameAndPassword(username, password);
		boolean add = userService.add(username, password);
		
		if (user!=null){
			resp.getWriter().write("false");
		}else {
			resp.getWriter().write("true");
		}
	}
}
