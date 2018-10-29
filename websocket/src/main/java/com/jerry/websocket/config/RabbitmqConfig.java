package com.jerry.websocket.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jerry
 * @date 2018/10/12
 * 描述：
 * @description
 */
@Configuration
public class RabbitmqConfig {

    /**
     * 定义路由
     */
    private static String RouteKey = "webMagic.message";

    /**
     * 定义队列
     * @return
     */
    @Bean
    public Queue webMagicQueue(){
        return new Queue("webMagic");
    }

    /**
     * 定义交换机
     */
    @Bean
    public DirectExchange webMagicExchange(){

        return new DirectExchange("webMagicExchange",false,false);

    }

    /**
     * 绑定交换机与队列
     */
    @Bean
    public Binding webMagicBinding(){

        return BindingBuilder.bind(webMagicQueue()).to(webMagicExchange()).with(RouteKey);

    }
}
