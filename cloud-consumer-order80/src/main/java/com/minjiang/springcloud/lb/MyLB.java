package com.minjiang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther guannw
 * @create 2021/1/23 20:26
 */
@Component
public class MyLB implements LoadBalancer {

    //原子整数，原子为最小单位，也就是原子不可被分割执行完才可继续
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            //获取当前初始值
            current = this.atomicInteger.get();
            //2147483647为Integer 最大值
            next  = current >= 2147483647 ? 0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));//自旋锁，当atomicInteger的值与next一样时边才会返回值
        System.out.println("*****第几次访问，次数next"+next);
        return next;//next代表第几次访问
    }

    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
