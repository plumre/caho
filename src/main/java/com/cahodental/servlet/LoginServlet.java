package com.cahodental.servlet;

/*
 * Created by renhongjiang on 2019/2/22.
 */

import com.cahodental.domain.User;
import com.cahodental.service.UserService;
import com.cahodental.service.impl.UserServiceImpl;
import com.cahodental.util.UUIDUtils;
import com.mysql.cj.util.StringUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/22 16:21
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = -7477406408407319861L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (StringUtils.isNullOrEmpty(name) || StringUtils.isNullOrEmpty(password)) {
            req.setAttribute("msg", "请输入有效的用户名和密码");
            req.getRequestDispatcher(req.getContextPath()+"/login.jsp").forward(req, resp);
            return;
        }

        UserService userService = new UserServiceImpl();
        try {
            User user = userService.getUserByCodeOrName(null, name);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*// 接收数据 封装 业务层 页面跳转
        String nickname = req.getParameter("nickname");
        String email = req.getParameter("email");

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setEmail(email);
        // 0 未激活 1 激活
        user.setState(0);
        user.setCode(UUIDUtils.getUUID());

        UserService userService = new UserServiceImpl();
        try {
            userService.regist(user);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        // 跳转
        req.setAttribute("msg", "您已注册成功！请去邮箱激活");*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}