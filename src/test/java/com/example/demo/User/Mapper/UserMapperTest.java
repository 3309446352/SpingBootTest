package com.example.demo.User.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.User.entity.User;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

class UserMapperTest {
    @Resource
    UserMapper userMapper;
    @Test
    public void Usertest(){

            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_name","黑马程序员");
            userMapper.selectList(queryWrapper).forEach(System.out::println);
            User user = userMapper.selectById(1);
            System.out.println(user);

    }

}