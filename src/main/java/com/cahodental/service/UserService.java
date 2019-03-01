package com.cahodental.service;

/*
 * Created by renhongjiang on 2019/2/22.
 */

import com.cahodental.domain.User;

import javax.mail.MessagingException;
import java.sql.SQLException;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/22 16:20
 */
public interface UserService {

    void regist(User user) throws MessagingException;

    User getUserByCodeOrName(String code, String name) throws SQLException;

    void activeUser(Integer id) throws SQLException;
}