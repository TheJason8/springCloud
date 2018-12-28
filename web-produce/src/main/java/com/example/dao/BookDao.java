package com.example.dao;

import com.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface BookDao extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

               @Query(value = "from Book where bookName=?1")
                Book findByName(String name);
}
