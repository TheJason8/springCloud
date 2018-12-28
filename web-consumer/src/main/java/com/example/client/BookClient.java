package com.example.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("BOOK-SERVICE")//指定远程调用的服务名
public interface BookClient {

    //根据书名查询书本信息，远程调用Produce请求数据
    @GetMapping("/book/findByName/{name}") //用GetMapping标识远程调用的http方法类型
    String sellBook(@PathVariable("name") String name);

    @GetMapping("/findAll")
    String findAll();


}
