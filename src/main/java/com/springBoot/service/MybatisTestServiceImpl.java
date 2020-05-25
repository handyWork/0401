package com.springBoot.service;

import com.springBoot.dao.Librarian;
import com.springBoot.dao.ProductorMapper;
import org.springframework.stereotype.Service;

@Service
public class MybatisTestServiceImpl implements MybatisTestService {


//    @Override
//    public void selectInfoById(int id) {
//
//    }

    private ProductorMapper productorMapper;

    @Override
    public Librarian selectLibrarian(int id) {
        // TODO Auto-generated method stub
        return productorMapper.selectLibrarian(id);
    }
}
