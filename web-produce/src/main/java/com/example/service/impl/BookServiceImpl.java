package com.example.service.impl;


import com.example.dao.BookDao;
import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;



@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao dao;

    @Autowired
    private RedisTemplate redisTemplate;//变量名不能为template 否则自动注入报错

    @Override
    public List<Book> findAll() {
        List<Book> bookList=new ArrayList<>();
        bookList= redisTemplate.boundHashOps("bookList").values();
        if (bookList==null || bookList.size()==0){
            bookList=dao.findAll();
            for (Book book : bookList) {
                redisTemplate.boundHashOps("bookList").put(book.getBookName(),book);
            }
        }else{
            System.out.println("从redis缓存中获取");
        }
        return bookList;
    }

    @Override
    public Book findByName(String name) {
        Book book=new Book();
        book = (Book) redisTemplate.boundHashOps("bookList").get(name);
        if(book==null){
            book=dao.findByName(name);
            if(book!=null){
                redisTemplate.boundHashOps("bookList").put(name,book);
            }
        }else{
            System.out.println("从缓存中获取书本信息");
        }
        return book;
    }
}
