package com.testPackage.applicationTest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@Component  和这个注解差不多但是有点区别      都是声明这个bean时，但是在调用这个bean时，@Component是直接new出来的，而@configuration是通过代理拿到的，
//直接从beanfactory中拿到的  所以是同一个对象
//@Configuration
@ComponentScan("com.testPackage")
@EnableAspectJAutoProxy
public class AppConfig {

}
