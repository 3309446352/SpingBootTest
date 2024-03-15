package com.example.demo.User.util;

import cn.hutool.crypto.SecureUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class HutoolUtils {
    public void  setMd5(String password) {
        String md5 = SecureUtil.md5(password);
        System.out.println(md5);
    }

}
