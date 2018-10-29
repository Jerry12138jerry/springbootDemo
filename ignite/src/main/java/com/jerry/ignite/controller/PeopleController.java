package com.jerry.ignite.controller;

import com.jerry.ignite.config.IgniteCfg;
import com.jerry.ignite.entity.People;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jerry
 * @date 2018/10/15
 * 描述：前端访问处理controller
 */
@RestController
public class PeopleController {

    Ignite ignite = IgniteCfg.IgniteInstance();

    @RequestMapping(value = "/save")
    public String savePeople(@RequestBody String name){

        System.out.println("传入的name是："+name);
        IgniteCache<Integer, String> firstTestcache = ignite.getOrCreateCache("firstTestCache");
        firstTestcache.put(1,name);
        return name;

    }

    @RequestMapping(value = "/query")
    public String queryPeople(@RequestBody String name){

        System.out.println("传入的name是:"+name);
        IgniteCache<Integer, String> firstTestcache = ignite.getOrCreateCache("firstTestCache");
        String str = firstTestcache.get(1);
        return str;

    }
}
