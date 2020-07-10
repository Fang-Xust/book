package fang.model;/*
 * @Program:booksys
 * @Description:description
 * @Author:Pufang
 * @Time:2020-07-06 18-37-01
 **/

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 图书信息
 */
@Getter
@Setter
@ToString
public class Book extends DictionaryTag{

    private Integer id;

    /**
     * 图书名称
     */
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 创建时间
     */
    private Date createTime;
}
