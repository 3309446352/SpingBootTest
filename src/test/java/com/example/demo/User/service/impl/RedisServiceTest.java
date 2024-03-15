package com.example.demo.User.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.User.Mapper.UserMapper;
import com.example.demo.User.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import javax.annotation.Resource;
@SpringBootTest
class RedisServiceTest {
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private UserMapper userMapper;
    @Test
    void set() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", 88);
        System.out.println(userMapper.selectList(queryWrapper));
    }
}