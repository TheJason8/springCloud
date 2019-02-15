package com.example.pojo;



import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
public class Book implements Serializable {

    @ApiModelProperty("书本id")
    private Integer bookId;

    @ApiModelProperty("书籍名")
    private String bookName;

    @ApiModelProperty("书籍库存")
    private Integer bookNum;

    @ApiModelProperty("内容描述")
    private String bookDesc;

    @ApiModelProperty("价格")
    private Integer bookPrice;

}
