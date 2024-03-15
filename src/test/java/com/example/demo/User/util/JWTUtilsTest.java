package com.example.demo.User.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JWTUtilsTest {

    @Test
    void setjwttoken() {
        JWTUtils jwtUtils = new JWTUtils();
        jwtUtils.Setjwttoken();
    }
}