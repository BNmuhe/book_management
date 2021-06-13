package com.bookmanager.demo.dao;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.bookmanager.demo.domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class BookDao {
    private DruidPooledConnection connection;

    private QueryRunner runner=new QueryRunner();

    public void setConnection(DruidPooledConnection connection) {
        this.connection = connection;
    }

    private static final String ADD_BOOK_SQL="insert into book values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String DELETE_BOOK_SQL="delete from book where book_id=?";

    private static final String QUERY_BOOK_SQL="select * from book where book_id=?";


    public void add(Book book) throws SQLException {
        runner.update(ADD_BOOK_SQL,book.getBookId(),book.getName(),book.getAuthor(),book.getPublish(),book.getIntroduction(),book.getLanguage(),
                book.getPrice(),book.getPubdate(),book.getClassId(),book.getPressmark(),book.getState(),book.getInventory(),book.getTotal());
    }

    public void delete(Book book) throws SQLException {
        runner.update(DELETE_BOOK_SQL,book.getBookId());
    }

    public Book query(int BookId) throws SQLException{
        BeanHandler<Book> handler=new BeanHandler<>(Book.class);
        return runner.query(QUERY_BOOK_SQL,handler,BookId);
    }

    public void update(Book book) throws SQLException {
        delete(book);
        add(book);
    }

}
