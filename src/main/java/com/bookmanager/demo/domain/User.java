package com.bookmanager.demo.domain;

import java.util.Date;

public class User {
    private int userId;
    private String name;
    private String sex;
    private Date birth;
    private String address;
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String passwd) {
        this.password = passwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(int readerId) {
        this.userId = readerId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public Date getBirth() {
        return birth;
    }

    public String getAddress() {
        return address;
    }

    public String getSex() {
        return sex;
    }


}
