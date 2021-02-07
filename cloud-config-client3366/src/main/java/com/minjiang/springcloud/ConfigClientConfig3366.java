package com.minjiang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther guannw
 * @create 2021/1/31 21:29
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientConfig3366 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientConfig3366.class,args);
    }
}
