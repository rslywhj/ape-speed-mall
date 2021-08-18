package com.tjetc.user.controller;

import com.google.gson.Gson;
import com.tjetc.user.service.UserShopService;
import com.tjetc.user.service.impl.UserShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = {"/toTakeDelivery"})
public class ToTakeDelivery extends HttpServlet{
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            UserShopService userShopService= new UserShopServiceImpl();
            //3、获取参数
            String oid = req.getParameter("oid");
            long l = Long.parseLong(oid);
            //4、调用方法
            Boolean aBoolean = userShopService.toTakeDelivery(l);
            Gson gson = new Gson();
            String json = gson.toJson(aBoolean);
            //5、返回json数据格式（因为前端使用ajax技术，所以后端不能跳转）
            //判断user是否为null，为null表示不存在对应用户名密码，不为null说明查找到用户，把用户信息存储到session中，返回登陆成功
            //但不要跳转，跳转页面交给前端，后端只负责提供数据
            if (json!=null){
                resp.getWriter().write(json);
            }else {
                resp.getWriter().write("false");
            }
        }
}
