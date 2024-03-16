package com.example.demo.User.util;

import cn.hutool.crypto.SecureUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
@ApiModel(description = "Hutool工具类",value = "Hutool工具类",parent = Object.class)
public class HutoolUtils {
    @ApiModelProperty("主键id")//注解swagger2注入password
    public void  setMd5(String password) {
        String md5 = SecureUtil.md5(password);
        System.out.println(md5);
    }

}
