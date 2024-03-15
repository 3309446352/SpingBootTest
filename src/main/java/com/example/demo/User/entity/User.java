package com.example.demo.User.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2024-03-04 23:16:00
 */
@SuppressWarnings("serial")
@Data
@TableName("user")
public  class User{
//用户id
    @TableId(type = IdType.AUTO)
    private Integer userId;
//用户名称
    private String userName;
//用户密码
    private String userPassword;
//用户邮箱（用户账号）
    private String userEmail;
//用户角色
    private String userRole;
//用户状态（0:正常,1:禁用）
    private String userStatus;

}

