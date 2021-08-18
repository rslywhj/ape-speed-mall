package com.tjetc.admin.controller.login;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/validateCode"})
public class ValidateCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");*/
        // 1 创建验证码
        ValidateCode validateCode = new ValidateCode(100, 30, 4, 30);
        // 2 将验证码存储到Session
        HttpSession session = req.getSession();
        session.setAttribute("validateCode", validateCode.getCode());
        // 3 将验证码以图片的形式发给浏览器
        validateCode.write(resp.getOutputStream());
    }
}
