package com.example.demo.User.controller;

import com.example.demo.User.service.impl.RedisService;
import com.example.demo.User.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@RequestMapping("/redis")
public class RedisCotroller {
    @Resource
    private RedisService redisService;
    @Autowired
    RedisUtils redisUtils;

    @GetMapping("/redisone")
    public Object redis(Integer id){
        return redisService.Set(id);
    }

    @GetMapping("/redistwo")
    public Object getRedis(@RequestParam(value = "id"  ) int id){
        return redisService.getRedis2(id);
    }

}
