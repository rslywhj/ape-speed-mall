
package com.tjetc.user.controller;


import com.google.gson.Gson;

import com.tjetc.user.entity.CartAndPro;
import com.tjetc.user.entity.Goods;
import com.tjetc.user.entity.User;
import com.tjetc.user.service.CartService;
import com.tjetc.user.service.GoodsService;
import com.tjetc.user.service.impl.CartServiceImpl;
import com.tjetc.user.service.impl.GoodsServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cart/a"})
public class CartUpdateServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    GoodsService goodsService=new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession().getAttribute("user");
        Long user_id = user.getId();
        Long product_id =Long.parseLong(req.getParameter("id"));
        String num = req.getParameter("num");
        int i1 = Integer.parseInt(num);
        Goods goods = goodsService.selectGoods(product_id);
        CartAndPro cartAndPro = new CartAndPro(user_id, product_id, goods.getProduct_name(), goods.getPrice(), i1);
        boolean b = cartService.addById(cartAndPro);
        Gson gson = new Gson();
        String json = gson.toJson(b);
        try {
            resp.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req,resp);
    }
}

