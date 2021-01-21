package com.minjiang.springcloud.service;

import com.minjiang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @auther guannw
 * @create 2021/1/3 20:44
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
