package com.testPackage.applicationTest.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
//Spring中的Aop和Aspectj的最大区别是  Spring中的 Aop是在运行期植入的   而Aspectj中的是在编译期中植入的
public class handyAspectj {
    //定义一个切点
    //执行服务包或其子包中定义的任何方法
    @Pointcut("execution(* com.testPackage.applicationTest.service..*.*(..))")
    public void pointCut(){

    }
    //这个before要作用到哪个切点
    @Before("pointCut()")
    public void before(){
        System.out.println("aop-------befor");
    }


}
