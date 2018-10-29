package com.jerry.elasticsearch.controller;

import com.jerry.elasticsearch.dao.PersonRepository;
import com.jerry.elasticsearch.entity.Person;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


/**
 * @author Jerry
 * @date 2018/10/10
 * 描述：
 */
@RestController
public class TestController {

    @Autowired
    PersonRepository repository;

    Person person = new Person();

    @GetMapping(value = "/test")
    public String test(){
        person.setId(1);
        person.setUsername("jerry");
        person.setPassword("123456");
        repository.save(person);
        return "helloWorld";
    }

    @GetMapping(value = "/query")
    public List<Person>  query(){
        Iterable<Person> iterable = repository.findAll();
        Iterator<Person> iterator = iterable.iterator();
        List<Person> list = IteratorUtils.toList(iterator);
        return list;
    }

    @GetMapping(value = "/queryOne")
    public Optional<Person> queryOne(){

        Optional<Person> person = repository.findById(1L);

        return person;

    }

}
