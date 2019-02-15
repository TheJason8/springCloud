package com.example.controller;

import com.example.pojo.Book;
import com.example.service.CBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value="书店数据获取接口",description = "数据增删改查",tags = "tags")
public class BookController {

    @Autowired
    private CBookService service;

    @RequestMapping(value = "/sellBook",method = RequestMethod.GET)
    @ApiOperation("出售具体某一本书。。。")
public Book SellBook(@ApiParam(name="Book",value="出售",required = true)
                    String bookName){
    return service.sellBook(bookName);
}

    @RequestMapping(value="/countBooks",method = RequestMethod.GET)
    @ApiOperation("查询所有的书籍。。。")
public String countBooks(){
        return service.findAll();
}

}
