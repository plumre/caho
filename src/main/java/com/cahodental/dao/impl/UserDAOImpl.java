package com.cahodental.dao.impl;

/*
 * Created by renhongjiang on 2019/2/22.
 */

import com.cahodental.dao.UserDAO;
import com.cahodental.domain.User;
import com.cahodental.util.JDBCUtils;
import com.mysql.cj.util.StringUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/22 16:36
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void regist(User user) {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataResource());
        String sql = "insert into user(name,password,nickname,email,state,code,gmt_create) values(?,?,?,?,?,?,?)";
        Object[] params = {user.getName(), user.getPassword(), user.getPassword(),
                user.getNickname(), user.getEmail(), user.getState(), user.getCode(), user.getGmtCreate()};
        try {
            runner.execute(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByCodeOrName(String code, String name) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataResource());
        String sql;
        User user;
        if (!StringUtils.isNullOrEmpty(code)) {
            sql = "select * from user where code = ?";
            user = runner.query(sql, new BeanHandler<>(User.class), code);
        } else {
            sql = "select * from user where name = ?";
            user = runner.query(sql, new BeanHandler<>(User.class), name);
        }
        return user;
    }

    @Override
    public void updateUserState(Integer id) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataResource());
        String sql = "update user set state = 1 where id = ?";
        runner.execute(sql, id);
    }
}