package com.cahodental.filter;

/*
 * Created by renhongjiang on 2019/2/26.
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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
@WebFilter(filterName = "FirstFilter", urlPatterns = {"/index.jsp"}, dispatcherTypes = {DispatcherType.REQUEST})
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("****   FirstFilter   ****");
        System.out.println("****    F开始过滤     ****");
        chain.doFilter(request, response);

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
//        req.getRequestDispatcher("index.jsp").forward(req, resp);
        /*resp.sendRedirect(req.getContextPath()+"/index.jsp");*/


        System.out.println("****    F结束过滤     ****");
    }

    @Override
    public void destroy() {

    }
}