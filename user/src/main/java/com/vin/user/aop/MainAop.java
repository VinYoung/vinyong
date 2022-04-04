package com.vin.user.aop;

import com.vin.web.model.ResponseModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class MainAop {

//    //切点
//    @Pointcut("execution(public * com.vin.web.controller.UserController.login())")
//    private void login(){};
//
//    //增加粉丝通知
//    @Before("login()")
//    public Object createToken(ProceedingJoinPoint joinPoint) throws Throwable {
//
//
//
//        return joinPoint.proceed();
//    }

//    //增加粉丝通知
//    @Before("authCheck()")
//    public Object authCheck(ProceedingJoinPoint joinPoint) throws Throwable {
//
//
//
//
//        return responseModel;
//    }
}
