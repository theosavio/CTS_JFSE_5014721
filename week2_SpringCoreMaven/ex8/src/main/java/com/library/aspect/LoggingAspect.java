package com.library.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Pointcut for all methods in BookService
    @Pointcut("execution(* com.library.service.BookService.*(..))")
    public void bookServiceMethods() {}

    // Before advice
    @Before("bookServiceMethods()")
    public void logBefore() {
        System.out.println("Logging before method execution.");
    }

    // After advice
    @After("bookServiceMethods()")
    public void logAfter() {
        System.out.println("Logging after method execution.");
    }

    // AfterReturning advice
    @AfterReturning("bookServiceMethods()")
    public void logAfterReturning() {
        System.out.println("Logging after method has successfully returned.");
    }
}
