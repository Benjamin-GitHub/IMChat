package com.ztesoft.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lym on 2018/3/20.
 */
@RestController
@RequestMapping("/imChat")
public class IMChatController {

    @Value("${imChat.serverAddr}")
    private String imChatServerAddr;

    @GetMapping("/getIMChatServerAddr")
    public String getIMChatServerAddr() {
        return imChatServerAddr;
    }

}
