package com.cralor.ch2.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Controller 的所有方法在执行前后都会进入simpleAOP方法
 * Created by cc.
 * 2018/6/13 10:25
 **/
@Configuration
@Aspect
public class AOPConfig {

    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object simpleAOP(final ProceedingJoinPoint pjp)throws Throwable{
        try {
            Object[] args=pjp.getArgs();
            System.out.println("args:"+Arrays.asList(args));
            //调用原有方法
            Object o=pjp.proceed();
            System.out.println("return:"+o);
            return o;
        }catch (Throwable e){
            throw e;
        }

    }
}
