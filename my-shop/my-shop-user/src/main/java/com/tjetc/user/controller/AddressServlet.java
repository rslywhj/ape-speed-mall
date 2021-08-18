package com.tjetc.user.controller;

import com.google.gson.Gson;
import com.tjetc.user.common.Result;
import com.tjetc.user.common.Result1;
import com.tjetc.user.entity.Address;
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

@WebServlet(urlPatterns = {"/address"})
public class AddressServlet extends HttpServlet {
     UserShopService userShopService=new UserShopServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Long user_id = user.getId();
        List<Address> list = userShopService.selectAddress(user_id);
        Gson gson = new Gson();
        Result1 result1 = new Result1(list);
        String s = gson.toJson(result1);
        resp.getWriter().write(s);

    }
}
