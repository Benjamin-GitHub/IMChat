package com.ztesoft.websocket;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContextFactory implements ApplicationContextAware {
      
    private static ApplicationContext applicationContext;
  
  
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        applicationContext = ac;  
    }  
      
    public static ApplicationContext getApplicationContext(){  
        return applicationContext;  
    }     
    }