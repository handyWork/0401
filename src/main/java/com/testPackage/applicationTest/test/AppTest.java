package com.testPackage.applicationTest.test;

import com.testPackage.applicationTest.AppConfig;
import com.testPackage.applicationTest.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        System.out.println(annotationConfigApplicationContext.getBean(IndexService.class).getClass().getName());
        annotationConfigApplicationContext.getBean(IndexService.class).query();

    }
}
