package com.minjiang.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @auther guannw
 * @create 2021/1/25 21:00
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService_paymentInfo_OK fall back....";
    }

    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService_paymentInfo_TimeOut fall back....";
    }
}
