package com.example.demo.User.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (Record)实体类
 *
 * @author makejava
 * @since 2024-03-16 23:34:24
 */
@Data
@TableName("record")
public class Record implements Serializable {

/**
     * 借阅记录id
     */
    @TableId(type = IdType.AUTO)
    private Integer recordId;
/**
     * 借阅的图书名称
     */
    private String recordBookname;
/**
     * 借阅的图书的ISBN编号
     */
    private String recordBookisbn;
/**
     * 图书借阅人
     */
    private String recordBorrower;
/**
     * 图书借阅时间
     */
    private String recordBorrowtime;
/**
     * 图书归还时间
     */
    private String recordRemandtime;

}

