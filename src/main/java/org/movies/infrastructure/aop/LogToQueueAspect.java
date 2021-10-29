package org.movies.infrastructure.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogToQueueAspect {

    @Around("@annotation(LogToQueue)")
    public Object logToQueue(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("worked!");
        return joinPoint.proceed();
    }
}
