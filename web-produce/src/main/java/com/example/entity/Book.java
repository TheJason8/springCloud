package com.example.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book")
@Data
@ToString
public class Book implements Serializable {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_num")
    private Integer bookNum;

    @Column(name = "book_desc")
    private String bookDesc;

    @Column(name = "book_price")
    private Integer bookPrice;

}
