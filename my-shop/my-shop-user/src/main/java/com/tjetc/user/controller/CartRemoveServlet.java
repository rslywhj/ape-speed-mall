package com.tjetc.user.controller;

import com.tjetc.user.service.CartService;
import com.tjetc.user.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cart/remove"})
public class CartRemoveServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String id1 = req.getParameter("id");
        long id = Long.parseLong(id1);
        cartService.removeById(id);
    }
}
