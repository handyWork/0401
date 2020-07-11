package com.testPackage.spring.bootAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect//声明这是一个切面
@Component//声明这是一个组件，泛指...可以去掉
public class AspectIntercepter {

    @Pointcut(value = "execution(* com.testPackage.spring.bootAop.personServerImpl.*(..))")
    private void pointCut() {//定义一个切入点 后面的通知直接引入切入点方法pointCut即可            personServerImpl下面的所有方法
    }

    //环绕通知（连接到切入点开始执行，下一步进入前置通知，在下一步才是执行操作方法）
    @Around(value = "pointCut()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("@Around进入环绕通知...");
        Object object = pjp.proceed();//执行该方法
        System.out.println(pjp.getThis() + "  操作结束，退出方法;环绕[@Around]结束！...");
        return object;
    }

    //前置通知（进入环绕后执行，下一步执行方法）
    @Before(value = "pointCut()")
    public void doAccessCheck(JoinPoint joinPoint) {
        System.out.println("@Before前置通知:" + Arrays.toString(joinPoint.getArgs()));
    }

    //异常通知（出错时执行）
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void doAfterThrow(JoinPoint joinPoint, Throwable ex) {
        System.out.println("@AfterThrowing例外通知(异常通知)" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("@AfterThrowing异常信息：" + ex);
    }

    //后置通知(返回之前执行)
    @After(value = "pointCut()")
    public void after() {
        System.out.println("@After后置通知...");
    }

    //最终通知（正常返回通知，最后执行）
    @AfterReturning(value = "pointCut()")
    public void doAfter() {
        System.out.println("@AfterReturning最终通知...End!");
    }
}