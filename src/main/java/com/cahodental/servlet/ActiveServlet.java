package com.cahodental.servlet;

/*
 * Created by renhongjiang on 2019/2/22.
 */

import com.cahodental.domain.User;
import com.cahodental.service.UserService;
import com.cahodental.service.impl.UserServiceImpl;

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
 * @date 2019/2/22 17:19
 */
public class ActiveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        UserService service = new UserServiceImpl();
        try {
            User user = service.getUserByCodeOrName(code, null);
            if (user != null) {
                service.activeUser(user.getId());
                req.setAttribute("msg", "您已激活成功");
            } else {
                req.setAttribute("msg", "您的激活码有误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}