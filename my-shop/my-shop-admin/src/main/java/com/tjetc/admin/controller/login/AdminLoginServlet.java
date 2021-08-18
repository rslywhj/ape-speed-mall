package com.tjetc.admin.controller.login;

import com.tjetc.service.service.LoginService;
import com.tjetc.service.service.OrderManagementService;
import com.tjetc.service.service.ProductService;
import com.tjetc.service.service.impl.LoginServiceImpl;
import com.tjetc.service.service.impl.OrderManagementServiceImpl;
import com.tjetc.service.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    LoginService loginService = new LoginServiceImpl();
    ProductService productService = new ProductServiceImpl();
    OrderManagementService orderManagementService = new OrderManagementServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        String validate1 = request.getParameter("validate");
        HttpSession session = request.getSession();
        String validate2 = (String) session.getAttribute("validateCode");
        System.out.println(validate2);
        String errorMsg="";

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Map<Integer, Long> map = productService.findCount();
        Long productCount = map.get(1);
        request.getSession().setAttribute("productCount",productCount);
        Long warehouseCount = map.get(2);
        request.getSession().setAttribute("warehouseCount",warehouseCount);


        Map<Integer, Long> map1 = orderManagementService.findCount();
        Long pendingCount = map1.get(2);
        request.getSession().setAttribute("pendingCount",pendingCount);
        Long shippedCount = map1.get(1);
        request.getSession().setAttribute("shippedCount",shippedCount);

        boolean bl = loginService.adminRegister(username, password);
        if (!validate1.equalsIgnoreCase(validate2)) {
            errorMsg="验证码错误,";
        }
        if(errorMsg!="") {
            response.sendRedirect("admin_login.jsp?codeError=yes");
        }else {
            if (username != null && password != null) {
                if (bl) {
                    request.getSession().setAttribute("username", username);
                    request.getSession().setAttribute("password", password);
                    response.sendRedirect(request.getContextPath() + "/admin/show.jsp");
                } else {
                    response.sendRedirect("admin_login.jsp?error=yes");
                }
            }


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
