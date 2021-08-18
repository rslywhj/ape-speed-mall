
package com.tjetc.user.controller;

import com.tjetc.user.service.CartService;
import com.tjetc.user.service.impl.CartServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cart/add"})
public class CartAddServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String id1 = req.getParameter("id");
        System.out.println("id1 = " + id1);
        long id = Long.parseLong(id1);
        cartService.addUpdate(id);
    }
}
