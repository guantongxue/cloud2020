package com.minjiang.springcloud.controller;

import com.minjiang.springcloud.entities.CommonResult;
import com.minjiang.springcloud.entities.Payment;
import com.minjiang.springcloud.service.PaymentFeignService;
import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther guannw
 * @create 2021/1/24 15:56
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign-ribbon,客户端一般等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
