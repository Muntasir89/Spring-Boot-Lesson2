package com.practice.firstproject.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Around("execution(* com.practice.firstproject.demo.ShoppingCart.checkout(..))")
    public Object aroundCheckout(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around checkout - Method will not execute");
        // Not calling proceed() - method body will never execute
        return null;
    }

    @Around("execution(String com.practice.firstproject.demo.ShoppingCart.getCartStatus())")
    public Object aroundGetStatus(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around getCartStatus - Returning custom value");
        // Not calling proceed() and returning our own value
        return "INTERCEPTED";
    }
}