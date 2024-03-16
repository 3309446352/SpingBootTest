package com.example.demo.User.config.Shiro;

import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean Bean = new ShiroFilterFactoryBean();//设置安全管理员
        Bean.setSecurityManager(securityManager);//安全管理员
        /*
        //添加shiro内置过滤器
        anon:无需认证
        authc:必须认证
        user:如果使用rememberMe的功能可以直接访问
        perms:该资源必须得到资源权限才可以访问
        role:该资源必须得到角色权限才可以访问
         */
        //TODO:"拦截" 权限设置
        Map<String,String> map = new HashMap<>();
        map.put("/main","authc");
        map.put("/manage","perms[manage]");
        map.put("/administrator","roles[administrator]");
        Bean.setFilterChainDefinitionMap(map);
        Bean.setLoginUrl("/login");//TODO:如果没有权限，跳转到登录页面
        //设置未授权页面
        Bean.setUnauthorizedUrl("/unauth");//TODO:如果没有权限，跳转到未授权页面
        Bean.getFilters();//TODO:获取过滤器
        Bean.getFilterChainDefinitionMap();//TODO:获取过滤器链
        Bean.getSuccessUrl();//

        return Bean;

    }
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("UserRealm") UserRealm UserRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.getObjectPermissions();
        manager.setRealm(UserRealm);//设置UserRealm
        return manager;
    }

    @Bean
    //创建UserRealm对象
    public UserRealm UserRealm(){
        return new UserRealm();
    }

    @Bean
    //创建ShiroDialect对象
    public UserRealm shiroDialect(){
        return new UserRealm();
    }
}
