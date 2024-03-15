package com.example.demo.User.service;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

class UserServiceTest {

    @Resource
    private UserService userService;    // This is the class that we are testing
    @Test
    void selectAll() {
        userService.UserPage(1,5);
    }
}