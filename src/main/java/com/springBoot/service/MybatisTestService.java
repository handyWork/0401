package com.springBoot.service;

import com.springBoot.dao.Librarian;

public interface MybatisTestService {

//public Librarian selectInfoById(int id);

    Librarian selectLibrarian(int id);
}
