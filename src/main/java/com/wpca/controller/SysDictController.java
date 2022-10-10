package com.wpca.controller;


import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wpca.common.lang.Const;
import com.wpca.common.lang.Result;
import com.wpca.entity.SysDict;
import com.wpca.entity.SysMenu;
import com.wpca.entity.SysRole;
import com.wpca.entity.SysUser;
import com.wpca.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WPCA
 * @since 2022-10-04
 */
@RestController
@RequestMapping("/sys/dict")
public class SysDictController extends BaseController {


    @Autowired
    SysDictService sysDictService;


    @GetMapping("/list")
    public Result list(String name) {


        Page<SysDict> pageData = sysDictService.page(getPage(),
                new QueryWrapper<SysDict>()
                        .like(StrUtil.isNotBlank(name), "name", name)
        );

        return Result.succ(pageData);
    }

    @GetMapping("/info/{id}")
    public Result info(@PathVariable Long id) {
        SysDict dict = sysDictService.getById(id);
        return Result.succ(dict);
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody SysDict sysDict) {
        sysDictService.save(sysDict);
        return Result.succ(sysDict);
    }

    @PostMapping("/update")
    public Result update(@Validated @RequestBody SysDict sysDict) {
        sysDictService.updateById(sysDict);
        // 清除所有与该菜单相关的权限缓存
        return Result.succ(sysDict);
    }
}
