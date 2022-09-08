package com.wpca.controller;


import com.wpca.common.lang.Result;
import com.wpca.entity.CoreAsso;
import com.wpca.service.CoreAssoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WPCA
 * @since 2022-09-04
 */
@RestController
@RequestMapping("/core")
public class CoreAssoController extends BaseController {

    @Autowired
    CoreAssoService coreAssoService;

    @GetMapping("/findAll")
    public Result findAll(){
        return Result.succ(coreAssoService.list());
    }

}
