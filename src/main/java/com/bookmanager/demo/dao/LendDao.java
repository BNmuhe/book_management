package com.bookmanager.demo.dao;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.bookmanager.demo.domain.Admin;
import com.bookmanager.demo.domain.Lend;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class LendDao {
    private DruidPooledConnection connection;

    private QueryRunner runner=new QueryRunner();

    public void setConnection(DruidPooledConnection connection) {
        this.connection = connection;
    }

    private static final String ADD_LEND_SQL="insert into lend values(?,?,?,?,?,?,?)";

    private static final String DELETE_LEND_SQL="delete from lend where LEND_id=?";

    private static final String QUERY_LEND_SQL="select * from lend where LEND_id=?";


    public void add(Lend lend) throws SQLException {
        runner.update(ADD_LEND_SQL,lend.getLendId(),lend.getBookId(),lend.getUserId(),lend.getLendDate(),lend.getBackDate(),lend.getPrice(),lend.getState());
    }

    public void delete(Lend lend) throws SQLException {
        runner.update(DELETE_LEND_SQL,lend.getLendId());
    }

    public Lend query(int LendId) throws SQLException{
        BeanHandler<Lend> handler=new BeanHandler<>(Lend.class);
        return runner.query(QUERY_LEND_SQL,handler,LendId);
    }

    public void update(Lend lend) throws SQLException {
        delete(lend);
        add(lend);
    }


}
