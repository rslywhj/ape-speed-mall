package com.tjetc.admin.controller.category;

import com.alibaba.fastjson.JSONObject;
import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.entity.Category;
import com.tjetc.service.service.ProductService;
import com.tjetc.service.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/list-category"})
public class ListCategoryServlet extends HttpServlet{
    ProductService productService=new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchKey = req.getParameter("searchKey");
        String strDraw = req.getParameter("draw");
        String strStart = req.getParameter("start");
        String strLength = req.getParameter("length");
        int draw = Integer.parseInt(strDraw);
        int start = Integer.parseInt(strStart);
        int pageSize = Integer.parseInt(strLength);
        AdminPageResult<Category> result = productService.listCategory(start, pageSize);
        result.setDraw(draw);
        String json = JSONObject.toJSONString(result);
        resp.getWriter().write(json);
    }
}
