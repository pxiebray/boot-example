package com.ztest.boot.mvc.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/11/9 0009 21
 */
@Controller
public class BulletController {

    @MessageMapping("/chat")
    @SendTo("/toAll/bulletScreen")
    public String say(BulletMessageVO message) {
        System.out.println("recived message! " + message.toString());
        return message.toString();
    }

}
