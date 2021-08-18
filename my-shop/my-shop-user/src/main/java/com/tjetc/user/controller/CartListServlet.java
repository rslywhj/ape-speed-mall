
package com.tjetc.user.controller;

import com.google.gson.Gson;
import com.tjetc.user.common.Result;
import com.tjetc.user.entity.CartAndPro;
import com.tjetc.user.entity.User;
import com.tjetc.user.service.CartService;
import com.tjetc.user.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/cart"})
public class CartListServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        Long user_id = user.getId();
        List<CartAndPro> cartAndPros = cartService.findAllCart(user_id);
        Gson gson = new Gson();
        Result result = new Result(cartAndPros);
        String s = gson.toJson(result);
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

