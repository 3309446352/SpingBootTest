package com.example.demo.User.controller;

import com.example.demo.User.service.impl.RedisService;
import com.example.demo.User.util.RedisUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@RestController
@RequestMapping("/redis")
public class RedisCotroller {
    @Resource
    private RedisService redisService;
    @Autowired
    RedisUtils redisUtils;

    @GetMapping("/redisone")
    @ApiOperation(value = "redis测试",notes = "redis测试")//该注解用来对某个方法/接口进行描述
    @ApiParam(name = "id",value = "id",required = true)//该注解用来对某个参数进行描述
    public Object redis(Integer id){
        return redisService.Set(id);
    }

    @GetMapping("/redistwo")
    public Object getRedis(@RequestParam(value = "id"  ) int id){
        return redisService.getRedis2(id);
    }

}
