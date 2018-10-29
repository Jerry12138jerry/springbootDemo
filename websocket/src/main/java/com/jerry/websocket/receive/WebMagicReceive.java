package com.jerry.websocket.receive;

import com.jerry.webmagic.server.WebSocketServer;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Jerry
 * @date 2018/10/12
 * 描述：
 */
@Component
@RabbitListener(queues="webMagic")
public class WebMagicReceive {

    @RabbitHandler
    public void process(String price){

        System.out.println("我是webSocket服务,我拿到了价格"+price);

        for(WebSocketServer webSocketServer :WebSocketServer.webSockets){
            try {
                webSocketServer.send(price);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
