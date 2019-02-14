package com.itheima.ssm.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

import java.lang.reflect.Method;
import java.util.Date;

public class LogAop {

    private Date startTime; // 访问时间
    private Class executionClass;// 访问的类
    private Method executionMethod; // 访问的方法


    /**
     * 编写前置通知
     * @param joinPoint
     */
    @Before("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint){

    }


    /**
     * 编写后置通知
     * @param joinPoint
     */
    @After("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint){

    }
}
