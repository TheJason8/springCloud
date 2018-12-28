package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/findAll")
    public List<Book> findAll() {
        List<Book> all = service.findAll();
        System.out.println(all);
        return all;
    }

    @GetMapping("/book/findByName/{name}")
    public Book findByName(@PathVariable("name") String name){
        return   service.findByName(name);
    }
}
