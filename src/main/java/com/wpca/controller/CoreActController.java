package com.wpca.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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



    @GetMapping("/get/{actId}")
    public Map<String, Object> getActInfo(@PathVariable("actId")String actId){



        return null;
    }
}
