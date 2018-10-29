package com.jerry.elasticsearch.dao;

import com.jerry.elasticsearch.entity.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Jerry
 * @date 2018/10/10
 * @description
 */

public interface PersonRepository extends ElasticsearchRepository<Person,Long> {
}
