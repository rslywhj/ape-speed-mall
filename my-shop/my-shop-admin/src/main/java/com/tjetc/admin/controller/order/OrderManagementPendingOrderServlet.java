package com.tjetc.admin.controller.order;

import com.alibaba.fastjson.JSONObject;
import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.entity.OrderManagement;
import com.tjetc.service.service.OrderManagementService;
import com.tjetc.service.service.impl.OrderManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 待发货
 */
@WebServlet(urlPatterns = {"/orderManagement/page1"})
public class OrderManagementPendingOrderServlet extends HttpServlet {
    OrderManagementService orderManagementService = new OrderManagementServiceImpl();
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
        AdminPageResult<OrderManagement> result = orderManagementService.page(start, pageSize);

        Map<Integer, Long> map = orderManagementService.findCount();
        Long pendingCount = map.get(2);


        req.getSession().setAttribute("pendingCount",pendingCount);
        result.setDraw(draw);
        String json = JSONObject.toJSONString(result);
        resp.getWriter().write(json);
    }
}
