package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fuguofeng
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderMain80zk {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain80zk.class, args);
    }

}
