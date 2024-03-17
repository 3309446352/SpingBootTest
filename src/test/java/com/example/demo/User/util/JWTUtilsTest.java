package com.example.demo.User.util;

import org.junit.jupiter.api.Test;

class JWTUtilsTest {

    @Test
    void setjwttoken() {
        JWTUtils jwtUtils = new JWTUtils();
        jwtUtils.SetToken();
    }

    @Test
    void getjwtutils() {
        JWTUtils jwtUtils = new JWTUtils();
        jwtUtils.Getjwttoken("123456","admin");
    }
}