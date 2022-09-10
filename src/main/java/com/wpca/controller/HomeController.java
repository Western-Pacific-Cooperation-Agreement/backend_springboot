package com.wpca.controller;

import com.wpca.common.lang.Result;
import com.wpca.service.CoreActService;
import com.wpca.service.ExpansionRotationchartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.controller.HomeController
 * @Date 2022年09月10日 10:35
 * @Description
 */

@RestController
@RequestMapping("/home")
public class HomeController extends BaseController{

    @Autowired
    ExpansionRotationchartService expansionRotationchartService;

    @Autowired
    CoreActService coreActService;


    /**
     *
     * @methodName getRotationChart
     * @description 获得轮播图
     * @return com.wpca.common.lang.Result
     * @CreateTime 10:31 2022/9/10
     * @UpdateTime 10:31 2022/9/10
     */
    @GetMapping("/get/rotationChart")
    public Result getRotationChart(){
        return Result.succ(expansionRotationchartService.list());
    }

    /**
     *
     * @methodName getHotAct
     * @description 获得热门活动
     * @return com.wpca.common.lang.Result
     * @CreateTime 10:45 2022/9/10
     * @UpdateTime 10:45 2022/9/10
     */

    @GetMapping("/get/hotAct")
    public Result getHotAct(){
            return Result.succ(coreActService.list());
    }

    /**
     *
     * @methodName getHotAct
     * @description 获得热门活动
     * @return com.wpca.common.lang.Result
     * @CreateTime 10:45 2022/9/10
     * @UpdateTime 10:45 2022/9/10
     */

    @GetMapping("/get/recommendAct")
    public Result getRecommendAct(){
        return Result.succ(coreActService.list());
    }

}
