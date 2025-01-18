package com.sr.scm;

import com.sr.scm.annotations.annotation.CustomAnnotation;
import com.sr.scm.annotations.scanner.CustomScanner;
import com.sr.scm.aop.LoggingAOP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Method;

@SpringBootApplication

public class SchoolManagementSystemV3Application {


	public static void main(String[] args) {


		SpringApplication.run(SchoolManagementSystemV3Application.class, args);
		new CustomScanner().scanAndRegisterComponents("com.sr.scm");
		Class<?>[] classes={LoggingAOP.class};
		for(Class<?> clazz:classes)
		{
			System.out.println("processing class "+clazz.getName());
			for(Method method:clazz.getMethods())
			{
				if(method.isAnnotationPresent(CustomAnnotation.class))
				{
					CustomAnnotation customAnnotation=method.getAnnotation(CustomAnnotation.class);
					System.out.println(customAnnotation.number());
					System.out.println(customAnnotation.price());
					System.out.println(customAnnotation.value());
				}
			}
		}
	}

}
