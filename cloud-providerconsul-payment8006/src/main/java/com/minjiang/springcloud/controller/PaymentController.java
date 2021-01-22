package com.minjiang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @auther guannw
 * @create 2021/1/22 13:14
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul",method = RequestMethod.GET)
    public String paymentConsul(){
        return "springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
