package com.example.demo.User.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.User.entity.User;
import com.example.demo.User.service.impl.UserServiceImpl;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-03-04 23:16:00
 */
public interface UserService{

    Page<User> UserPage(Integer pageNo, Integer pageSize);
}

