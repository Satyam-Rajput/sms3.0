package com.sr.scm.aop;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sr.scm.annotations.annotation.CustomAnnotation;
import com.sr.scm.controllers.StudentController;
import com.sr.scm.entities.Student;
import org.aopalliance.intercept.MethodInterceptor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.annotations.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class LoggingAOP {

    @Before("execution(* com.sr.scm.controllers..*(..))")
    public void printLogs(ProceedingJoinPoint point)
    {
//        System.out.println(point.getArgs());
//        System.out.println(point.getKind());
//        System.out.println(point.getSignature());
//        System.out.println(point.getSignature().getDeclaringType());
//        System.out.println(point.getSignature().getName());
//        System.out.println(point.getSignature().getModifiers());
//        System.out.println(point.getSignature().getDeclaringTypeName());
//        System.out.println(point.getTarget());
//        System.out.println(point.getSourceLocation());
//        System.out.println(point.getSourceLocation().getFileName());
//        System.out.println(point.getSourceLocation().getLine());
        System.out.println("logs printed before");

    }

    @After("execution(* com.sr.scm.controllers..*(..))")
    public void printLogsAfter(JoinPoint point)
    {
//        System.out.println(point.getKind());
//        System.out.println(point.getSignature());
//        System.out.println(point.getSignature().getDeclaringType());
//        System.out.println(point.getSignature().getName());
//        System.out.println(point.getSignature().getModifiers());
//        System.out.println(point.getSignature().getDeclaringTypeName());
//        System.out.println(point.getTarget());
//        System.out.println(point.getSourceLocation());
//        System.out.println(point.getSourceLocation().getFileName());
//        System.out.println(point.getSourceLocation().getLine());
        System.out.println("logs printed After");
    }

    @AfterReturning("execution(* com.sr.scm.controllers..*(..))")
    public void printLogsAfterReturning(JoinPoint point)
    {
//        System.out.println(point.getArgs());
//        System.out.println(point.getKind());
//        System.out.println(point.getSignature());
//        System.out.println(point.getSignature().getDeclaringType());
//        System.out.println(point.getSignature().getName());
//        System.out.println(point.getSignature().getModifiers());
//        System.out.println(point.getSignature().getDeclaringTypeName());
//        System.out.println(point.getTarget());
//        System.out.println(point.getSourceLocation());
//        System.out.println(point.getSourceLocation().getFileName());
//        System.out.println(point.getSourceLocation().getLine());
        System.out.println("logs printed after returning");
    }


    @AfterThrowing("execution(* com.sr.scm.controllers..*(..))")
    public void printLogsAfterThrowing(JoinPoint point)
    {
//        System.out.println(point.getArgs());
//        System.out.println(point.getKind());
//        System.out.println(point.getSignature());
//        System.out.println(point.getSignature().getDeclaringType());
//        System.out.println(point.getSignature().getName());
//        System.out.println(point.getSignature().getModifiers());
//        System.out.println(point.getSignature().getDeclaringTypeName());
//        System.out.println(point.getTarget());
//        System.out.println(point.getSourceLocation());
//        System.out.println(point.getSourceLocation().getFileName());
//        System.out.println(point.getSourceLocation().getLine());
        System.out.println("logs printed after throwing");
    }


    @Around("execution(* com.sr.scm.controllers..*(..))")
    @CustomAnnotation(value="hello",number=10,price=0.0)
    public Object printLogsAfterAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println(point.getArgs());
//        System.out.println(point.getKind());
//        System.out.println(point.getSignature());
//        System.out.println(point.getSignature().getDeclaringType());
//        System.out.println(point.getSignature().getName());
//        System.out.println(point.getSignature().getModifiers());
//        System.out.println(point.getSignature().getDeclaringTypeName());
//        System.out.println(point.getTarget());
//        System.out.println(point.getSourceLocation());
//        System.out.println(point.getSourceLocation().getFileName());
//        System.out.println(point.getSourceLocation().getLine());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println("logs printed after around");
        Object obj=joinPoint.proceed();

        return obj;
    }
}
