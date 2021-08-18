package com.tjetc.user.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "a_characterFilter",initParams = {@WebInitParam(name = "charset", value = "UTF-8")})
public class CharacterEncodingFilter implements Filter {
    private String defaultCharset = "UTF-8";
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取初始化的参数
        String charset = this.filterConfig.getInitParameter("charset");
        if (charset == null) {
            charset = defaultCharset;
        }
        //设置request的编码
        request.setCharacterEncoding(charset);
        //设置response的编码
        response.setCharacterEncoding(charset);
        /*response.setHeader("Content-type", "text/html;charset=" + charset);*/
        //保证执行其他的Filter
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
 