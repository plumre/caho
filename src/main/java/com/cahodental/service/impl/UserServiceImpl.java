package com.cahodental.service.impl;

/*
 * Created by renhongjiang on 2019/2/22.
 */

import com.cahodental.dao.UserDAO;
import com.cahodental.dao.impl.UserDAOImpl;
import com.cahodental.domain.User;
import com.cahodental.service.UserService;
import com.cahodental.util.MailUtils;

import javax.mail.MessagingException;
import java.sql.SQLException;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/22 16:21
 */
public class UserServiceImpl implements UserService {

    @Override
    public void regist(User user) throws MessagingException {
        // 存数据 发激活邮件
        UserDAO userDAO = new UserDAOImpl();
        userDAO.regist(user);
        MailUtils.sendMail(user.getEmail(), user.getCode());

    }

    @Override
    public User getUserByCodeOrName(String code, String name) throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        return userDAO.getUserByCodeOrName(code, name);
    }

    @Override
    public void activeUser(Integer id) throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        userDAO.updateUserState(id);
    }
}