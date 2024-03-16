package com.example.demo.User.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Book)实体类
 *
 * @author makejava
 * @since 2024-03-16 23:32:15
 */
@Data
public class Book {

/**
     * 图书编号
     */
    private Integer bookId;
/**
     * 图书名称
     */
    private String bookName;
/**
     * 图书标准ISBN编号
     */
    private String bookIsbn;
/**
     * 图书出版社
     */
    private String bookPress;
/**
     * 图书作者
     */
    private String bookAuthor;
/**
     * 图书页数
     */
    private Integer bookPagination;
/**
     * 图书价格
     */
    private Object bookPrice;
/**
     * 图书上架时间
     */
    private String bookUploadtime;
/**
     * 图书状态（0：可借阅，1:已借阅，2：归还中，3：已下架）
     */
    private String bookStatus;
/**
     * 图书借阅人
     */
    private String bookBorrower;
/**
     * 图书借阅时间
     */
    private String bookBorrowtime;
/**
     * 图书预计归还时间
     */
    private String bookReturntime;

}

