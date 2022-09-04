package com.wpca.controller;

import com.wpca.service.CoreAssoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: TestController
 * @Author Huang Jinpo
 * @Date: 2022/9/4 17:42
 * @Version 1.0
 */
@RestController
public class TestController {

    @Autowired
    CoreAssoService coreAssoService;

    @GetMapping("/test")
    public Object test(){
        return coreAssoService.list();

    }
}
