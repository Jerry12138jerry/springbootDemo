package com.jerry.ignite.entity;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Jerry
 * @date 2018/10/15
 * 描述：ignite操作实体
 */
public class People {

    private static final AtomicLong ID_GEN = new AtomicLong();

    @QuerySqlField(index = true)
    private long id;

    @QuerySqlField
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People(String name) {
        //id自增
        this.id = ID_GEN.incrementAndGet();
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
