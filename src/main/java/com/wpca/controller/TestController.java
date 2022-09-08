package com.wpca.controller;

import com.wpca.common.lang.Result;
import com.wpca.service.CoreAssoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/test")
    public Result test(){

        return Result.succ(coreAssoService.list());
    }

    @GetMapping("/test/pass")
    public Result pass() {
        // 加密后密码
        String password = bCryptPasswordEncoder.encode("111111");

        boolean matches = bCryptPasswordEncoder.matches("111111", password);

        System.out.println("匹配结果：" + matches);

        return Result.succ(password);
    }

}
