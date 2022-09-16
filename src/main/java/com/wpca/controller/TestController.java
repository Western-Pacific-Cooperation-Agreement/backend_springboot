package com.wpca.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wpca.common.lang.Result;
import com.wpca.entity.CoreAct;
import com.wpca.service.CoreActService;
import com.wpca.service.CoreAssoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Autowired
    CoreActService coreActService;


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

    @GetMapping("/test/getone")
    public Result getone() {
                                                            //2022-09-06T16:00:00.000Z
//        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.000Z");
//        String dateStr = "2022-09-06 16:00:00.000Z";
//        LocalDateTime date2 = LocalDateTime.parse(dateStr, fmt);
//        System.out.println(date2);
        String time="2022-09-06T16:00:00.000Z";
        time = time.substring(0,19);//2022-09-06T16:00:00
        time=time.replace('T',' ');//2022-09-06 16:00:00
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(time, pattern);

        return Result.succ(parse);

    }
}
