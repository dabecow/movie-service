package org.movies.infrastructure.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.movies.infrastructure.mq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class LogToQueueAspect {

    @Autowired
    private Sender sender;

    @Before("@annotation(LogToQueue)")
    public void logBefore(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String output = "INFO [LogToQueue] " + method.getName() + " just called with args: " + Arrays.toString(method.getParameters());
        System.out.println(output);
        sender.send(output);
    }

    @AfterReturning(value = "@annotation(LogToQueue)", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result){
        String output = "INFO [LogToQueue] method " + joinPoint.getSignature().getName() + " just returned " + result.toString();
        System.out.println(output);
        sender.send(output);
    }
}
