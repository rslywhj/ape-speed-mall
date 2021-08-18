
package com.tjetc.user.controller;

import com.tjetc.user.service.CartService;
import com.tjetc.user.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cart/removeall"})
public class CartRemoveAllServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String listIds = req.getParameter("listIds");
        String[] split = listIds.split(",");
        cartService.delAll(split);
    }
}
