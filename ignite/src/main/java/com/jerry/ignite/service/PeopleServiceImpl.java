package com.jerry.ignite.service;

import com.jerry.ignite.entity.People;
import com.jerry.ignite.repo.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jerry
 * @date 2018/10/15
 * 描述：service接口实现类
 */
@Service
public class PeopleServiceImpl implements PeopleService{

    @Autowired
    private PeopleRepository repository;

    @Override
    public People save(People people) {
        return repository.save(people);
    }

    @Override
    public People findPeopleByName(String name) {
        return repository.findByName(name);
    }
}
