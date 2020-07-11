package com.testPackage.spring.bootAop;

import org.springframework.stereotype.Service;

@Service("personServer")
public class personServerImpl implements personServer  {

    @Override
    public void save(String uname, int age) {
//        int a=0;
//        age= age/a;//打开上面两行报错，可触发异常通知
        System.out.println("come in personServerImpl save method...");
    }
}
