package com.example.controller;

import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

    @Autowired
    private BookService service;

    @RequestMapping("/sellBook")
public String SellBook(String bookName){
    return service.sellBook(bookName);
}

    @RequestMapping("/countBooks")
public String countBooks(){
        return service.findAll();
}

}
