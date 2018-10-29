package com.jerry.ignite.config;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jerry
 * @date 2018/10/15
 * 描述：ignite配置类
 */
public class IgniteCfg{

    /**
     * 单例ignite
     * @return ignite
     */
    public static Ignite IgniteInstance(){
        IgniteConfiguration cfg = new IgniteConfiguration();
        //设置节点名称
        cfg.setIgniteInstanceName("springDataNode");
        //开启分布式
        cfg.setPeerClassLoadingEnabled(false);
        //缓存相关配置
        CacheConfiguration ccfg = new CacheConfiguration("PeopleCache");
        //将缓存配置加载到节点配置
        cfg.setCacheConfiguration(ccfg);
        return Ignition.start(cfg);
    }
}
