package com.tjetc.admin.controller.category;

import com.alibaba.fastjson.JSONObject;
import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.entity.First;
import com.tjetc.service.entity.Second;
import com.tjetc.service.service.ProductService;
import com.tjetc.service.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/get-category"})
public class GetCategoryServlet extends HttpServlet {
    ProductService productService=new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        switch (op){
            case "first":{

                AdminPageResult<First> result = productService.listFirst();

                String json = JSONObject.toJSONString(result);
                System.out.println(json);
                resp.getWriter().write(json);
                break;
            }
            case "second":{
                System.out.println("hhh");
                String strFid = req.getParameter("first_id");
                int fid = Integer.parseInt(strFid);
                AdminPageResult<Second> result = productService.listSecond(fid);
                String json = JSONObject.toJSONString(result);
                resp.getWriter().write(json);
                break;
            }
        }
    }
}
