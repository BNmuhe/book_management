package com.bookmanager.demo.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Lend {

    private long lendId;
    private int userId;
    private long bookId;
    private Date lendDate;
    private Date backDate;
    private BigDecimal price;
    private int state;


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getLendId() {
        return lendId;
    }

    public void setLendId(long lendId) {
        this.lendId = lendId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }


}
