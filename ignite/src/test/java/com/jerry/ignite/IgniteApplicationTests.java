package com.jerry.ignite;

import com.jerry.ignite.entity.People;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IgniteApplicationTests {

    @Test
    public void contextLoads() {

        IgniteConfiguration cfg = new IgniteConfiguration();
        //设置节点名称
        cfg.setIgniteInstanceName("springDataNode");
        //集群模式开关
        cfg.setPeerClassLoadingEnabled(false);
        //缓存相关配置
        CacheConfiguration ccfg = new CacheConfiguration("PeopleCache");
        cfg.setCacheConfiguration(ccfg);
        Ignite ignite = Ignition.start(cfg);
        IgniteCache<Integer, String> firstTestcache = ignite.getOrCreateCache("firstTestCache");
        String str = firstTestcache.get(1);
        System.out.println(str);

    }
    }

