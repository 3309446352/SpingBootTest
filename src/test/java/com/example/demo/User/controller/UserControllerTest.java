package com.example.demo.User.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.User.Mapper.UserMapper;
import com.example.demo.User.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import javax.xml.ws.Action;
@Slf4j
class UserControllerTest {
    @Resource
    private UserMapper userMapper;
    @Qualifier("userController")
    private UserController userController;
    @Resource
    private Logger logger;
    @Test

    public void Usertest(){
        log.info("测试成功");
    }


}