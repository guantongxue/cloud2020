package com.minjiang.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @auther guannw
 * @create 2021/1/24 21:40
 */
@Component
public interface PaymentService {
    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);
}
