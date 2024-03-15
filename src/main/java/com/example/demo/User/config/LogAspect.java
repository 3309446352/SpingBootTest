package com.example.demo.User.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class LogAspect {
    @Pointcut("@annotation(com.example.demo.User.config.IfNull)")
    public void logPoint() {//这就是个标志，爱叫啥叫啥，给下面用的
    }

    @Before("logPoint()")
    public void beforeAop() {
        System.out.println("=====================================================");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String time = sdf.format(d);
        System.out.println("Time                "+time);
        System.out.println("请求方法              "+request.getMethod());
        System.out.println("请求路径              "+request.getRequestURI());
        System.out.println("请求IP               "+request.getRemoteAddr());
        System.out.println("请求类方法            "+request.getClass().getName());
        System.out.println("请求参数              "+request.getQueryString());
        System.out.println("请求头                "+request.getHeader("User-Agent"));
        System.out.println("请求时间               "+(sdf.format(d)));
        System.out.println("执行次数              "+request.getRequestURI() +"已经执行"+ count+ "次");
        countMethod();
    }


    public static int count = 1;
    public static void countMethod() {
        count++;
    }

    @After("logPoint()")
    public void afterNotify() {
        System.out.println("===========================================================");
        
    }

    @AfterReturning("logPoint()")
    public void afterReturningNotify() {
        System.out.println();
    }

    @AfterThrowing("logPoint()")
    public void afterThrowingNotify() {
        System.out.println("********@AfterThrowing我是异常通知");
    }

    @Around("logPoint()")
    public Object around(ProceedingJoinPoint Point) throws Throwable {
        Object result = Point.proceed();
        return result;
    }
}