package com.example.demo.User.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.User.Mapper.UserMapper;
import com.example.demo.User.config.Allocation.IfNull.IfNull;
import com.example.demo.User.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserMapper userMapper;
    public Object Set(Integer id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        List<User> result = userMapper.selectList(queryWrapper);
        System.out.println(result);
        redisTemplate.opsForValue().set("user", result);

        return redisTemplate.opsForValue().get("user");
    }
    @IfNull
    public Object getRedis() {
        return redisTemplate.opsForValue().get("user");
    }
    @IfNull
    public Object getRedis2(int id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("user_id", id);
        List<User> result = userMapper.selectList(queryWrapper);
        boolean One =ObjectUtil.isEmpty(result);
        if (One) {
            System.out.println(true);
            return "查询失败";
        }else {
            System.out.println(result);
            return redisTemplate.opsForList().leftPushAll("user", result);
        }


    }

}
