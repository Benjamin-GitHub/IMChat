package com.ztesoft.util.common;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tian.xubo
 * @created 2017 - 10 - 16 23:10
 */
public class BeanFactory {
    private static final Logger log = Logger.getLogger(BeanFactory.class);
    private static  ApplicationContext ctx ;
    private static  Boolean springBoot = true;


    public static void setCtx(ApplicationContext ctx) {
        BeanFactory.ctx = ctx;
    }
    public static Object lookup(String name){
        Object obj = ctx.getBean(name);
        if(obj == null){
            log.error("<frame>bean "+name+" not found!");
        }
        return obj;
    }
    public static Object lookup(Class name){
        Object obj = ctx.getBean(name);
        if(obj == null){
            log.error("<frame>bean "+name+" not found!");
        }
        return obj;
    }
}