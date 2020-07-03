package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fuguofeng
 * EnableDiscoveryClient 用zookeeper当作注册中心，也要用该注解实现服务发现功能
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentProviderMain8004ZK {

    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderMain8004ZK.class, args);
    }

}
