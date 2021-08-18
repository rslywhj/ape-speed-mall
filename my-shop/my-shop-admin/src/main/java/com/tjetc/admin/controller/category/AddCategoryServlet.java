package com.tjetc.admin.controller.category;

import com.tjetc.service.service.ProductService;
import com.tjetc.service.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/add/category"})
public class AddCategoryServlet extends HttpServlet {
    ProductService  productService=new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("first_name");

        String second_name = req.getParameter("second_name");
        boolean bl = productService.addCategory(first_name, second_name);
        if (bl){
            resp.sendRedirect(req.getContextPath()+"admin/listCategory.jsp");
        }else {
            resp.getWriter().write("添加失败");
        }


    }
}
