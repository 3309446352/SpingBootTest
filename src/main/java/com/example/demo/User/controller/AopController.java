package com.example.demo.User.controller;

import com.example.demo.User.config.Allocation.IfNull.IfNull;
import com.example.demo.User.service.impl.SpringAopTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/Aop")
public class AopController {
    @Autowired
    SpringAopTestService springAopTestService;

    @RequestMapping("/test")
    public void aopTest(){
        springAopTestService.message();
    }
    @RequestMapping("/anoMessage")
    @IfNull
    public String anoMessage() {
        return springAopTestService.anoMessage();
    }
}
