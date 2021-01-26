package com.minjiang.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther guannw
 * @create 2021/1/24 21:40
 */
@Component
public interface PaymentService {
    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);

    public String paymentCiruitBreaker(@PathVariable("id") Integer id);
}
