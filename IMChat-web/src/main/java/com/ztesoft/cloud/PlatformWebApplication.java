package com.ztesoft.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication/*(exclude = {HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class,
        DataSourceAutoConfiguration.class})*/
//@EnableDiscoveryClient
//@EnableZuulProxy
//@EnableRedisHttpSession
//@ComponentScan(basePackages={"com.ztesoft.cloud"})
/**@Import(LoggerAdvice.class)
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3000)*/
public class PlatformWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformWebApplication.class, args);
    }
}
