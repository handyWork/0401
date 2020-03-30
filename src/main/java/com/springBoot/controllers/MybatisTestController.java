package com.springBoot.controllers;

import com.springBoot.entity.Librarian;
import com.springBoot.result.BaseRespResult;
import com.springBoot.service.MybatisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/handy/user")
public class MybatisTestController {

    @Autowired
    private MybatisTestService mybatisTestService;

    @ResponseBody
    @RequestMapping(value = {"/load"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public BaseRespResult load() {
        Librarian librarian = mybatisTestService.selectLibrarian(1);
        return BaseRespResult.successResult(librarian);

    }


}
