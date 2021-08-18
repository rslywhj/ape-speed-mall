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
@WebServlet(urlPatterns = {"/toApplyRefund"})
public class ToApplyRefundServlet extends HttpServlet{
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            UserShopService userShopService= new UserShopServiceImpl();
            //1、获取参数
            String oid = req.getParameter("oid");
            long l = Long.parseLong(oid);
            //2、调用方法
            Boolean aBoolean = userShopService.toApplyRefund(l);
            Gson gson = new Gson();
            String json = gson.toJson(aBoolean);
            //3、返回json数据格式（因为前端使用ajax技术，所以后端不能跳转）
            if (json!=null){
                resp.getWriter().write(json);
            }else {
                resp.getWriter().write("false");
            }
        }
    }

