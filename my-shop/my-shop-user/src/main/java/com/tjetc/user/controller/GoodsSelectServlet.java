package com.tjetc.user.controller;

import com.google.gson.Gson;
import com.tjetc.user.entity.Goods;
import com.tjetc.user.service.GoodsService;
import com.tjetc.user.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/goods"})
public class GoodsSelectServlet extends HttpServlet {
   GoodsService goodsService= new GoodsServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //3、获取id参数
        long id = Long.parseLong(req.getParameter("gid"));
        //4、调用service.findByUsernameAndPassword方法传入参数（username，password），检查是否可以登陆
        Goods goods = goodsService.selectGoods(id);
        //5、返回json数据格式（因为前端使用ajax技术，所以后端不能跳转）
        //判断user是否为null，为null表示不存在对应用户名密码，不为null说明查找到用户，把用户信息存储到session中，返回登陆成功
        //但不要跳转，跳转页面交给前端，后端只负责提供数据
        Gson gson = new Gson();
        String s = gson.toJson(goods);
        System.out.println(id);
        if(s!=null) {
            resp.getWriter().write(s);
        }else {
            resp.getWriter().write("false");
        }
    }
}

