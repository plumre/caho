package com.cahodental.filter;

/*
 * Created by renhongjiang on 2019/2/26.
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/26 10:37
 */
public class ErrorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("****   ErrorFilter   ****");
        System.out.println("****    E开始过滤     ****");
        chain.doFilter(request, response);

        System.out.println("****    E结束过滤     ****");
    }

    @Override
    public void destroy() {

    }
}