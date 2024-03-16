package com.example.demo.User.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtils {
    public String Getjwtutils() {
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");// 设置算法
        header.put("typ", "JWT");// 设置类型

        // 载核【Payload】
        Map<String, Object> payload = new HashMap<>();
        payload.put("sub", "1234567890");// 设置主题
        payload.put("name","John Doe");// 设置用户名
        payload.put("admin",true);// 设置是否是管理员
        payload.put("iat",1516239022);// 设置签发时间

        // 声明Token失效时间
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,300);// 300s

        // 生成Token
        String token = Jwts.builder()
                .setAudience("user")// 设置接收者
                .setHeader(header)// 设置Header
                .setClaims(payload) // 设置载核
                .setExpiration(instance.getTime())// 设置生效时间
                .signWith(SignatureAlgorithm.HS256,"secret") // 签名,这里采用私钥进行签名,不要泄露了自己的私钥信息
                .compact(); // 压缩生成xxx.xxx.xxx

        System.out.println(token);
        return token;
    }
    @Bean
    public void Setjwttoken(){
            // 生成的token
        String token = Getjwtutils();
            // 解析head信息
        JwsHeader jwsHeader = Jwts
                .parser() //
                .setSigningKey("secret")// 设置签名的私钥
                .parseClaimsJws(token)// 设置需要解析的token
                .getHeader();// 获取head信息
        System.out.println(jwsHeader); // {typ=JWT, alg=HS256}
        System.out.println("typ:"+jwsHeader.get("typ"));

        Claims claims = Jwts
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
                .getSignature();
        System.out.println(signature); // Ju5EzKBpUnuIRhDG1SU0NwMGsd9Jl_8YBcMM6PB2C20
        }

}
