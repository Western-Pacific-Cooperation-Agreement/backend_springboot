package com.wpca.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wpca.common.lang.Result;
import com.wpca.entity.CoreAct;
import com.wpca.service.CoreActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.controller.CoreActController
 * @Date 2022年09月06日 12:56
 * @Description
 */
@RestController
@RequestMapping("/act")
public class CoreActController extends BaseController{

    @Autowired
    CoreActService coreActService;

    /**
     *
     * @methodName getActInfo
     * @description 通过id获取对应活动的详情信息
     * @param actId
     * @return com.wpca.common.lang.Result
     * @CreateTime 12:05 2022/9/10
     * @UpdateTime 12:05 2022/9/10
     */

    @GetMapping("/get/{actId}")
    public Result getActInfo(@PathVariable("actId")Long actId){
        return Result.succ(coreActService.getById(actId));
    }
}
