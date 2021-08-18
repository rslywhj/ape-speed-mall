package com.tjetc.admin.filter;

import com.alibaba.fastjson.JSONObject;
import com.tjetc.admin.model.JsonResult;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/admin/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String username = (String) request.getSession().getAttribute("username");
        if (StringUtils.isBlank(username)) {
            //获取请求头的name为X-Requested-With对应的value值，如果存在说明是ajax请求
            String xRequestedWith = request.getHeader("X-Requested-With");
            if (StringUtils.isBlank(xRequestedWith)) {
                //非ajax请求
                //session中不存在username，需要登录，跳转等到登录页面
                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath + "/admin_login.jsp");
            } else {
                //ajax请求，返回一个json
                JsonResult result = new JsonResult(-1, "登录过期，请重新登录", null);
                //json字符串转换成对象(非泛型普通对象)
                //User user = JSON.parseObject(s, User.class);
                //json字符串转换成对象(有泛型对象)
                //List<User> users = JSON.parseObject(str, new TypeReference<List<User>>() {});
                //对象转换成json字符串
                String json = JSONObject.toJSONString(result);
                response.getWriter().write(json);
            }
        } else {
            //继续执行其他的filter
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
