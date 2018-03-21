package com.ztesoft.util.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lym on 2018/3/19.
 */
@Component
public class CorsConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/upload/*").allowedOrigins("*");
        registry.addMapping("/imuser/*").allowedOrigins("*");
        registry.addMapping("/immessage/**").allowedOrigins("*");
    }

}
