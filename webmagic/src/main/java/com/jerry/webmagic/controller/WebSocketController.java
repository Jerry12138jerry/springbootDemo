package com.jerry.webmagic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jerry
 * @date 2018/10/12
 */
@Controller
public class WebSocketController {

    @RequestMapping(value = "webSocket")
    public String webSocket(){

        return "webSocket";

    }
}
