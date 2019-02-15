package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(scanBasePackages = "com.example")
@EnableDiscoveryClient  //标识这是一个客户端
@EntityScan("com.example.entity")
public class WebProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebProduceApplication.class, args);
    }

}

