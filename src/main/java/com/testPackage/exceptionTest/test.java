package com.testPackage.exceptionTest;

import com.springBoot.exception.ExceptionEnum;
import com.springBoot.exception.StudyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class test {
    protected  Logger logger = LoggerFactory.getLogger(getClass());

    public  void testLogger(){
        int num = 1;
        if (num == 0) {
            String a = "我是测试数据";
            logger.info("test 中的a字段值为{}",a);
            logger.error("test22222 中的a字段值为{}",a);
        }else {
            System.out.println(new StudyException().getMessage(ExceptionEnum.ERROR_01.getCode()));
        }
    }

    public static void main(String[] args) {
        new test().testLogger();

    }
}
