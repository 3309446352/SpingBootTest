package com.example.demo.User.util;


import cn.hutool.crypto.SecureUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class JWTUtils {
    @Autowired
    HutoolUtils hutoolUtils;
    public String Getjwttoken(String username,String password) {
        // JWT头部分信息【Header】
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        // 载核【Payload】
        Map<String, Object> Payload = new HashMap<>();
        Payload.put("name",username);
        Payload.put("password",password);
        Payload.put("admin",true);

        // 声明Token失效时间
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,300);// 300s

        String autograph= "secret";
        // 生成Token
        String token = Jwts.builder()
                .setHeader(header)// 设置Header
                .setClaims(Payload)// 设置载核
                .setExpiration(instance.getTime())

                .setId("888")// 设置ID
                .setIssuer("admin")// 设置签发者 //推荐注册声明
                .setSubject("user")// 设置主题

                .signWith(SignatureAlgorithm.HS256, autograph)// 设置签名算法和密钥
                .compact(); // 压缩生成xxx.xxx.xxx

        System.out.println("token:=========\n"+token);
        return token;
    }
    public void SetToken() {
        // 生成的token
        String token = Getjwttoken("name","123456");
        // 解析head信息
        JwsHeader jwsHeader = Jwts
                .parser()// 解析器
                .setSigningKey("secret")// 设置签名密钥
                .parseClaimsJws(token)// 解析token
                .getHeader();// 获取头部信息

        System.out.println(jwsHeader); // {typ=JWT, alg=HS256}
        System.out.println("typ:"+jwsHeader.get("typ"));
        System.out.println("alg:"+jwsHeader.get("alg"));
        // 解析Payload
        Claims claims =    Jwts
                .parser()
                .setSigningKey("secret")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);// {sub=1234567890, name=John Doe, admin=true, exp=1663297431}
        System.out.println("admin:"+claims.get("admin"));

        // 解析Signature
        String signature =    Jwts
                .parser()
                .setSigningKey("secret")
                .parseClaimsJws(token)
                .getSignature();// 签名
        System.out.println(signature);//
    }
}
