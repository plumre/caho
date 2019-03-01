package com.cahodental.servlet;

/*
 * Created by renhongjiang on 2019/2/22.
 */

import com.cahodental.domain.User;
import com.cahodental.service.UserService;
import com.cahodental.service.impl.UserServiceImpl;
import com.cahodental.util.UUIDUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/22 16:21
 */
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = -7477406408407319861L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收数据 封装 业务层 页面跳转
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
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
        req.setAttribute("msg", "您已注册成功！请去邮箱激活");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}