package com.example.demo.User.config.Security;

//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SpringSecurity{
//@Override
//protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/cart/**").hasRole("USER")
//                .antMatchers("/order/**").hasRole("USER")
//                .antMatchers("/user/**").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/**").permitAll();
//        //开启自动配置的登录功能
//        http.formLogin();
//        http.csrf().disable();
//        http.logout().logoutSuccessUrl("/");
//        //记住我
//        http.rememberMe();
//    }
//@Override
//protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("1223").roles("vip1")
//                .and()
//                .withUser("user").password("1234").roles("vip2");
//    }

}
