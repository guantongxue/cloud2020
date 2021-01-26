package com.minjiang.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Time;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * @auther guannw
 * @create 2021/1/24 21:41
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    /**
     * 正常访问，肯定ok
     * */
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"PaymentInfo_OK,id:"+id+"\t"+"O(∩_∩)O哈哈";
    }
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id){
//        暂停几秒线程

        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOut,id:"+id+"\t"+"O(∩_∩)O哈哈"+"耗时:"+"秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "系统繁忙"+Thread.currentThread().getName()+"8001系统出错"+"paymentInfo_TimeOutHandler："+"id:"+id+"\t";
    }

    //服务熔断


    @HystrixCommand(fallbackMethod = "paymentCircuitBreak_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启短路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数限制
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸，就是10请求6次失败跳闸
    })
    public String paymentCiruitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw  new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();//==UUID.randomUUID().toString();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;

    }

    public String paymentCircuitBreak_fallback(@PathVariable("id") Integer id){
        return "id 不能负数,请稍后重试.........";
    }

}
