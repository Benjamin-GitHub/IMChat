package com.ztesoft;


import com.ztesoft.service.ImUserService;
import com.ztesoft.service.ImUserServiceImpl;
import com.ztesoft.service.RedisService;
import com.ztesoft.util.common.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableZuulProxy
@ComponentScan({"com.ztesoft.websocket","com.ztesoft.controller","com.ztesoft.dao","com.ztesoft.service","com.ztesoft.util"})
public class IMChatStart {


    private static RedisService service;
    private static ImUserService imService;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(IMChatStart.class, args);
        BeanFactory.setCtx(ctx);
        imService = ctx.getBean(ImUserServiceImpl.class);
        System.out.println(imService);
    }
}
