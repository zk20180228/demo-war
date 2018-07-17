package cn.ctcc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:自定义过滤器
 * @Author: zhangkui
 * @CreateDate: 2018/7/13 13:58
 * @Modifier: zhangkui
 * @version: V1.0
 */
//@WebFilter(filterName = "helloFilter",urlPatterns = {"/*"})
public class HelloFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("HelloFilter 被创建了。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        System.out.println(uri+"过滤器执行了。。。。。。。。。1");
        filterChain.doFilter(request,response);
        System.out.println(uri+"过滤器返回的时候执行执行了...........2");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器被销毁了。。。。。。。。。。。。。。。。。。。。。。");

    }
}
