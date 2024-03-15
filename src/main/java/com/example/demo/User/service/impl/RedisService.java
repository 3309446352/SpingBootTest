package com.example.demo.User.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.User.Mapper.UserMapper;
import com.example.demo.User.config.IfNull;
import com.example.demo.User.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
import static com.baomidou.mybatisplus.extension.toolkit.SimpleQuery.selectList;

>>>>>>> 5620f38 (we2)
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
    public Object getRedis2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("user_id", 10);
<<<<<<< HEAD
        ArrayList<User> result = (ArrayList<User>) userMapper.selectList(queryWrapper);
        System.out.println(result);
=======
        List<User> result = userMapper.selectList(queryWrapper);
>>>>>>> 5620f38 (we2)
        return redisTemplate.opsForList().leftPushAll("user", result);
    }

}
