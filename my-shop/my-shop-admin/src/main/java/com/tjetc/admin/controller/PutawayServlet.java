package com.tjetc.admin.controller;

import com.tjetc.service.service.ProductService;
import com.tjetc.service.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 上架商品
 */
@WebServlet("/putawayServlet")
public class PutawayServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer product_id = Integer.parseInt(id);
        boolean bl = productService.putaway(product_id);
        PrintWriter writer = response.getWriter();
        //{success}是业务上的成功与失败
        if (bl){
            writer.write("{\"success\":true}");
        }else {
            writer.write("{\"success\":false}");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
