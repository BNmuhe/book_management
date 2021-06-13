package com.bookmanager.demo.dao;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.bookmanager.demo.domain.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    private DruidPooledConnection connection;

    private QueryRunner runner=new QueryRunner();

    public void setConnection(DruidPooledConnection connection) {
        this.connection = connection;
    }

    private static final String ADD_USER_SQL="insert into user values(?,?)";

    private static final String DELETE_USER_SQL="delete from user where user_id=?";

    private static final String QUERY_USER_SQL="select * from user where user_id=?";



    public void add(Admin admin) throws SQLException {
        runner.update(ADD_ADMIN_SQL,admin.getAdminId(),admin.getPassword());
    }

    public void delete(Admin admin) throws SQLException {
        runner.update(DELETE_ADMIN_SQL,admin.getAdminId());
    }

    public Admin query(int AdminId) throws SQLException{
        BeanHandler<Admin> handler=new BeanHandler<>(Admin.class);
        return runner.query(QUERY_ADMIN_SQL,handler,AdminId);
    }

    public void update(Admin admin) throws SQLException {
        runner.update(UPDATE_ADMIN_SQL,admin.getAdminId(),admin.getPassword(),admin.getAdminId());
    }

}
