package com.example.service;

import com.example.client.BookClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;


@Service
public class BookService {

 /* @Autowired
 RestTemplate restTemplate;*/
 @Autowired
 BookClient bookClient;


@HystrixCommand(fallbackMethod = "SellErro")  //回调方法的参数列表，返回值类型必须与下面方法的一致，否则会出现fallback method wasn't found: addServiceFallback([class java.lang.Integer])
    public String sellBook(String bookNmae){
       /* String serviceId="BOOK-SERVICE";     // 该值就是book-service:8763或者 book-service:8764,必须在RestTemplate注入的地方@LoadBalanced
        //这种方式是通过restTemplate来发
        return restTemplate.getForObject("http://"+serviceId+"/book/findByName?name="+bookNmae,String.class);*/
     return bookClient.sellBook(bookNmae);
    }

    @HystrixCommand(fallbackMethod ="countErro" )
    public String findAll() {
        return bookClient.findAll();
    }


    public String countErro(){
        return "系统繁忙，请稍后再试";
    }

    public String SellErro(String bookNmae){
        return "抱歉，请稍后再试";
    }
}
