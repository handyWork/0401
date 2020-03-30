package com.springBoot.service;

import com.springBoot.entity.Librarian;
import com.springBoot.mapper.ProductorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MybatisTestService {

    @Autowired
    private ProductorMapper productorMapper;

    public Librarian selectLibrarian(int id) {
        return productorMapper.selectLibrarian(id);
    }
}
