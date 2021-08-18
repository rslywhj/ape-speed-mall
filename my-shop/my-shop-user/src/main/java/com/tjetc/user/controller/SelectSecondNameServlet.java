package com.tjetc.user.controller;

import com.google.gson.Gson;
import com.tjetc.user.service.GoodsService;
import com.tjetc.user.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/selectSecond"})
public class SelectSecondNameServlet extends HttpServlet {
   GoodsService goodsService= new GoodsServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("first_name");
        List<String> list = goodsService.selectSecondName(first_name);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        if (json!=null){
            resp.getWriter().write(json);
        }else {
            resp.getWriter().write("false");
        }
    }
}
