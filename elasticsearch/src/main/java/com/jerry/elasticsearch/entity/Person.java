package com.jerry.elasticsearch.entity;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author Jerry
 * @date 2018/10/10
 * 描述：
 * */
@Document(indexName="index_entity", type="tstype")
public class Person {

    private int id;

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
