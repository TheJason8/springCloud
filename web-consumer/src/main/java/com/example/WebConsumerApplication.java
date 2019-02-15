package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication(scanBasePackages = "com.example")
@EnableDiscoveryClient  //开启客户端查询注解
@Configuration          //自动注入注解（用于restTemplate）
@EnableFeignClients     //开启OpenFeign注解
@EnableCircuitBreaker        //开启Hystrix熔断注解
@EntityScan("com.example.pojo")
public class WebConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebConsumerApplication.class, args);
    }
}

