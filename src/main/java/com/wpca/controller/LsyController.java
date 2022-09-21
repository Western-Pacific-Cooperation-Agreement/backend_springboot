package com.wpca.controller;

import com.wpca.common.lang.Result;
import com.wpca.entity.CoreAct;
import com.wpca.service.CoreActService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author lsy
 * @Pcakage com.wpca.controller.LsyController
 * @Date 2022年09月12日
 * @Description
 *
 * 处理lsy请求
 */
@RestController
@Slf4j
@RequestMapping("/lsy")
public class LsyController extends BaseController{

    @Autowired
    CoreActService coreActService;

    /********************************-----------GET-----------*****************************/
    /**
     *
     * @methodName getAllAct
     * @description 获取所有act
     * @return com.wpca.common.lang.Result
     * @CreateTime  2022/9/12
     * @UpdateTime  2022/9/12
     */

    //获取所有活动
    @GetMapping("/get/AllAct")
    public Result getAllAct(){
        List<CoreAct> actList = coreActService.getAllAct();

        return Result.succ(actList);
    }




    //搜索活动
    @PostMapping("/post/searchAct")
    public Result getSearchList(@RequestBody Map map){

        List<CoreAct> actList = coreActService.getAllAct();

        return Result.succ(actList);
    }
}
