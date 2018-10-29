package com.jerry.ignite.service;

import com.jerry.ignite.entity.People;

/**
 * @author Jerry
 * @date 2018/10/15
 * 描述：service接口
 */
public interface PeopleService {

    People save(People people);

    People findPeopleByName(String name);

}
