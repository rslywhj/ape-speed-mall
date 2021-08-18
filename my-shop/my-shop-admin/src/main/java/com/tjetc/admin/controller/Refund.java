package com.tjetc.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.service.ChangeStateService;
import com.tjetc.service.service.impl.ChangeStateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/refund"})
public class Refund extends HttpServlet {
    ChangeStateService changeStateService=new ChangeStateServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gid = req.getParameter("oid");
        long l = Long.parseLong(gid);
        AdminPageResult<Boolean> result = changeStateService.Refund(l);
        String searchKey = req.getParameter("searchKey");
        String strDraw = req.getParameter("draw");

        //调用userService的page方法查询数据
       /* AdminPageResult<OrderManagement> result = orderManagementService.page(start, pageSize);
        result.setDraw(draw);*/

        String json = JSONObject.toJSONString(result);
        resp.getWriter().write(json);


    }
}
