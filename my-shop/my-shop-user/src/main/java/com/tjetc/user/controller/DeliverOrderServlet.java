package com.tjetc.user.controller;

import com.google.gson.Gson;
import com.tjetc.user.entity.Order;
import com.tjetc.user.entity.User;
import com.tjetc.user.service.UserShopService;
import com.tjetc.user.service.impl.UserShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查看自己已发货订单
 */

@WebServlet(urlPatterns = {"/deliver"})
public class DeliverOrderServlet extends HttpServlet {
   UserShopService userShopService= new UserShopServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Long user_id = user.getId();
        List<Order> deliver = userShopService.Deliver(user_id);
        Gson gson = new Gson();
        String json = gson.toJson(deliver);
        if(json!=null){
            resp.getWriter().write(json);
        }else {
            resp.getWriter().write("false");
        }
    }

    }

