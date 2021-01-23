package com.minjiang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @auther guannw
 * @create 2021/1/23 20:23
 */
public interface LoadBalancer {
    //得到我们服务的服务
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
