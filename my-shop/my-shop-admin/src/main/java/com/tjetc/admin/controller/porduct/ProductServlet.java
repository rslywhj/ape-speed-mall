package com.tjetc.admin.controller.porduct;

import com.alibaba.fastjson.JSONObject;
import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.entity.Product;
import com.tjetc.service.service.ProductService;
import com.tjetc.service.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String searchKey = request.getParameter("searchKey");
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        int draw = Integer.parseInt(strDraw);
        int start = Integer.parseInt(strStart);
        int pageSize = Integer.parseInt(strLength);

        AdminPageResult<Product> result = productService.page(start, pageSize);

        
        Map<Integer, Long> map = productService.findCount();
        Long productCount = map.get(1);
        request.getSession().setAttribute("productCount",productCount);

        Long warehouseCount = map.get(2);
        request.getSession().setAttribute("warehouseCount",warehouseCount);

        

        result.setDraw(draw);
        String json = JSONObject.toJSONString(result);
        response.getWriter().write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
