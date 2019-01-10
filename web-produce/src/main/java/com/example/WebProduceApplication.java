package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient  //标识这是一个客户端
public class WebProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebProduceApplication.class, args);
    }

}

