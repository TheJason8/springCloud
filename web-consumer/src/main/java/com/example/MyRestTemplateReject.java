package com.example;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyRestTemplateReject {

    //该注解告知Spring Cloud创建一个基于Ribbon的RestTemplate，才可以实现客户端负载均衡RestTemplate就具备了负载均衡的功能了
    @Bean
    @LoadBalanced//使用该注解时路径必须为服务名，不能为具体的路径，否则会报负载均衡错误
    RestTemplate restTemplate(){
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());//如果使用无参构造，则默认会使用HttpClient
    }

}
