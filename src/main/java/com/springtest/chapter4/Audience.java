package com.springtest.chapter4;

import org.aspectj.lang.annotation.*;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/6 14:08
 * @version v1.00
 */
@Aspect
public class Audience {
    @Pointcut("execution(* com.springtest.chapter4.Performance.perform(..))")
    public void performance() {
    }

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones.");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @After("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
