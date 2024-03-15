package com.example.demo.User.service.impl;

import com.example.demo.User.config.IfNull.IfNull;
import com.example.demo.User.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Administrator
 */
@Service
public class SpringAopTestService {
    @Autowired
    JWTUtils jwtutils;

    public void message() {
        System.out.println("message");
    }
    @IfNull
    public String anoMessage() {
        return "anoMessage";
    }
}
