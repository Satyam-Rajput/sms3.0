
package com.sr.scm;


import com.sr.scm.annotations.scanner.CustomScanner;
import com.sr.scm.aop.LoggingAOP;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {



    @Bean
    public LoggingAOP testAdvice() {
        return new LoggingAOP();
    }


    public Advisor advisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.sr.scm.controllers..*(..))");
        return new DefaultPointcutAdvisor((Pointcut) pointcut, (Advice) testAdvice());

    }





}
