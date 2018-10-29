package com.jerry.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * @author Jerry
 * @date 2018/10/8
 * 描述：
 * @description
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}


