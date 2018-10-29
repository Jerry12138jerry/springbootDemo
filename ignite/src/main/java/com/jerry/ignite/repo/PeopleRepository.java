package com.jerry.ignite.repo;

import com.jerry.ignite.entity.People;
import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

/**
 * @author Jerry
 * @date 2018/10/15
 * 描述：ignite数据库访问接口
 */
@RepositoryConfig(cacheName = "PersonCache")
public interface PeopleRepository extends IgniteRepository<People, Long> {

    People findByName(String name);


}
