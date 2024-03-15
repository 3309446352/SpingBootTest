package com.example.demo.User.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.User.Mapper.UserMapper;
import com.example.demo.User.entity.User;
import com.example.demo.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2024-03-04 23:16:00
 */
@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserMapper usermapper;
    @Override
    public Page<User> UserPage(Integer pageNo, Integer pageSize) {
        Page<User> page = new Page<>(pageNo, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        usermapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println("总条数 ------> " + page.getTotal());
        System.out.println("当前页数 ------> " + page.getCurrent());
        System.out.println("当前每页显示数 ------> " + page.getSize());
        System.out.println("总页数 ------> " + page.getPages());
        System.out.println("是否有上一页 ------> " + page.hasPrevious());
        System.out.println("是否有下一页 ------> " + page.hasNext());
        return usermapper.selectPage(page, null);
    }
}

