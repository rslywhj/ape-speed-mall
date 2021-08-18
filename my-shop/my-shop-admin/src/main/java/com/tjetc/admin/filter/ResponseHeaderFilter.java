package com.tjetc.admin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"*"})
public class ResponseHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        resp.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
        resp.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        //设置响应数据格式和编码
        /*resp.setContentType("application/json;charset=utf-8");*/
        filterChain.doFilter(req, resp);
    }
}
