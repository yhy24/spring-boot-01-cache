package com.yang.cache.intercepter;

import org.springframework.core.annotation.Order;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: yhy
 * @Date: 2019/5/16 17:23
 * @Version 1.0
 */
@WebFilter(urlPatterns = "/*", filterName = "dataFilter")
public class DataFilter implements Filter {
    private UrlPathHelper helper = new UrlPathHelper();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("******init()******");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("******doFilter()******");
        String url = helper.getLookupPathForRequest((HttpServletRequest) request);
        if (url.startsWith("/user")) {
        //TODO 处理业务逻辑的使用
            chain.doFilter(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("******destroy()******");
    }
}
