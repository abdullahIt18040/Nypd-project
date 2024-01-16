package com.master.springbootmasterclass.AspectCinfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Aspect
@Component
public class LogingAspect {

    @After("authenticationPointCard()")
    public void afterLogger()
    {
        System.out.println(" this is after logger .......");
    }


    @Pointcut("execution(* com.master.springbootmasterclass.controllers.*.*(..))")
    public  void authenticationPointCard()
    {
    }

     @Before("authenticationPointCard()")
    public void beforeLogger(JoinPoint joinPoint)
    {
        System.out.println(" this is before is loging ......."+joinPoint.getSignature());
    }
    @AfterReturning(value = "execution(* com.master.springbootmasterclass.controllers.*.*(..))",returning = "name")
    public void after(JoinPoint joinPoint,String name)
    {

        System.out.println("after returing method is calling "+name);
    }



    @AfterThrowing(value = "execution(* com.master.springbootmasterclass.controllers.*.*(..))",throwing = "e")
    public void after(JoinPoint joinPoint,Exception e)
    {

        System.out.println("after returing method is calling "+e.getMessage());
    }

@Around("authenticationPointCard()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object=joinPoint.proceed();
    System.out.println("around method called"+object);

        return object;
    }
}
