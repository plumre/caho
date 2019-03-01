package com.cahodental.dao;

/*
 * Created by renhongjiang on 2019/2/22.
 */

import com.cahodental.domain.User;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/22 16:20
 */
public interface UserDAO {

    void regist(User user);

    User getUserByCodeOrName(String code, String name) throws SQLException;

    void updateUserState(Integer id) throws SQLException;
}