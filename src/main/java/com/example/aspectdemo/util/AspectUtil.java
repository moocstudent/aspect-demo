package com.example.aspectdemo.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: Frank
 * @Date: 2021-06-23 9:49
 */
@Aspect
@Component
public class AspectUtil {

    @Pointcut("execution(public * com.example.aspectdemo.conr.*.*(..))")
    public void log() {
        System.out.println("log invoke");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Exception {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("Authorization");
        StringBuffer url =request.getRequestURL();
        System.out.println("url:"+url);
        //请求路径+请求方法+本次token,用于放入redis,放置多次请求,以append之后的url做为key
        url.append(request.getMethod()).append(token);

        System.out.println("token:"+token);

        Object[] args = joinPoint.getArgs();
        List<Object> collect = Stream.of(args).map(d -> {
            System.out.println(d);
            return d;
        }).collect(Collectors.toList());
        System.out.println("args:" + collect);
        System.out.println("doBefore invoke");
    }

    @After("log()")
    public void doAfter() {
        System.out.println("after");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        System.out.println("after returning object :" + object);
    }

}
