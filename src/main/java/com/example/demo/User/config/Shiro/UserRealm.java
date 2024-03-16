package com.example.demo.User.config.Shiro;

import com.example.demo.User.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Account;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserRealm extends AuthorizingRealm {
    // 用于用户认证"授权"
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        Subject subject = SecurityUtils.getSubject();//获取当前登录的用户信息
        User user = (User) subject.getPrincipal();//获取User对象

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission(user.getUserRole());//设置权限
        return null;
    }
    // 用于用户"认证"
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证");
        // 获取数据库中的用户名和密码
        //查找用户
        //可以加密
        //密码认证，shiro做
        return null;
    }

}
