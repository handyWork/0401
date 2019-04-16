package com.testPackage.applicationTest.service;

import org.springframework.stereotype.Component;

@Component("indexService")
public class IndexServiceImpl implements IndexService {
    @Override
    public void query() {
        System.out.println("Query------------");
    }
}
