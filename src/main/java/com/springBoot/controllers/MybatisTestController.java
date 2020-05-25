package com.springBoot.controllers;

import com.springBoot.dao.Librarian;
import com.springBoot.service.MybatisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class MybatisTestController {

    @Autowired
    private MybatisTestService mybatisTestService;

    @RequestMapping("/happy")
    @ResponseBody
    public String test() {
        Librarian librarian = mybatisTestService.selectLibrarian(1);

        return null;
    }

}
