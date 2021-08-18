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
 * 查看自己待付款订单
 */
@WebServlet(urlPatterns = {"/waitPaid"})
public class WaitPaidOrderServlet extends HttpServlet {
    UserShopService userShopService=new UserShopServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Long user_id = user.getId();
        List<Order> list = userShopService.waitPaid(user_id);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        if(json!=null){
            resp.getWriter().write(json);
        }else {
            resp.getWriter().write("false");
        }
    }
}
