package com.tjetc.admin.controller.vip;

import com.alibaba.fastjson.JSONObject;
import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.entity.VipManagement;
import com.tjetc.service.service.VipManagementService;
import com.tjetc.service.service.impl.VipManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/vipManagement/page"})

public class VipManagementServlet extends HttpServlet {
    VipManagementService vipManagementService = new VipManagementServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchKey = req.getParameter("searchKey");
        String strDraw = req.getParameter("draw");
        String strStart = req.getParameter("start");
        String strLength = req.getParameter("length");
        int draw = Integer.parseInt(strDraw);
        int start = Integer.parseInt(strStart);
        int pageSize = Integer.parseInt(strLength);

        //调用userService的page方法查询数据
        AdminPageResult<VipManagement> result = vipManagementService.page(start, pageSize);

        result.setDraw(draw);
        String json = JSONObject.toJSONString(result);
        resp.getWriter().write(json);

    }


}
