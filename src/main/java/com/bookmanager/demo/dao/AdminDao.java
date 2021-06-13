package com.bookmanager.demo.dao;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.bookmanager.demo.domain.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdminDao {
    private DruidPooledConnection connection;

    private QueryRunner runner=new QueryRunner();

    public void setConnection(DruidPooledConnection connection) {
        this.connection = connection;
    }

    private static final String ADD_ADMIN_SQL="insert into admin values(?,?)";

    private static final String DELETE_ADMIN_SQL="delete from admin where admin_id=?";

    private static final String QUERY_ADMIN_SQL="select * from admin where admin_id=?";

    private static final String UPDATE_ADMIN_SQL="update admin set admin_id=? password=? where admin_id=?";

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
