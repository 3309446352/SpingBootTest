package com.example.demo.User.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HutoolUtilsTest {

    @Test
    void setMd5() {
        HutoolUtils hutoolUtils = new HutoolUtils();
        hutoolUtils.setMd5("123456");
    }
}