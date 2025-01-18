package com.sr.scm.annotations.scanner;

import com.sr.scm.annotations.annotation.CustomAnnotation;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

public class CustomScanner {

    public void scanAndRegisterComponents(String basePackage) {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(CustomAnnotation.class));

        Set<BeanDefinition> beanDefinitions = scanner.findCandidateComponents(basePackage);
        for (BeanDefinition beanDefinition : beanDefinitions) {
            try {
                Class<?> clazz = Class.forName(beanDefinition.getBeanClassName());
                // Register the class in the application context
                System.out.println("Registering custom component: " + clazz.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
