package com.springBoot.service;

import com.springBoot.dao.Librarian;

public interface MybatisTestService {

public void selectInfoById(int id);

    Librarian selectLibrarian(int id);
}
