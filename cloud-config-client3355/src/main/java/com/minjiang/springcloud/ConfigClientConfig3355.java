package com.minjiang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.swing.*;

/**
 * @auther guannw
 * @create 2021/1/31 17:06
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientConfig3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientConfig3355.class,args);
    }
}
