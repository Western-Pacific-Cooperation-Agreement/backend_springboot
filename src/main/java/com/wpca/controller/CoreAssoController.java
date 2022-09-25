package com.wpca.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wpca.common.lang.Result;
import com.wpca.entity.CoreAsso;
import com.wpca.entity.SysRole;
import com.wpca.entity.SysRoleMenu;
import com.wpca.entity.SysUser;
import com.wpca.service.CoreAssoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WPCA
 * @since 2022-09-04
 */
@RestController
@RequestMapping("/coreAsso")
public class CoreAssoController extends BaseController {
    Integer updateId;

    @Autowired
    CoreAssoService coreAssoService;


    @GetMapping("/findAll")
    public Result findAll(String username){
        Page<SysUser> users = sysUserService.page(getPage(),
                new QueryWrapper<SysUser>()
                        .like(StrUtil.isNotBlank(username), "username", username)
        );
        return Result.succ(coreAssoService.list());
    }

    @GetMapping("/getAsso/{id}")
    public Result getAsso(@PathVariable Long id){
        return Result.succ(coreAssoService.getById(id));
    }

    @PostMapping("/delById")
    public Result deleteById(@RequestBody Integer[] ids){
        for(Integer id:ids) {
            coreAssoService.delById(id);
        }
        return Result.succ("删除成功");
    }

    @PostMapping("/addCoreAsso")
    public Result addCoreAsso(@RequestBody CoreAsso coreAsso){
        coreAssoService.addCoreAsso(coreAsso.getAssoName(),coreAsso.getAssotypeId(),coreAsso.getAssoNumber());
        return Result.succ("增加部门成功");
    }

    @PostMapping("/updateCoreAsso")
    public Result updateCoreAsso(@RequestBody CoreAsso coreAsso){

        coreAssoService.updateById(coreAsso);
        return Result.succ("编辑成功");
    }

    @PostMapping("/getCoreAssoByName")
    public Result getCoreAssoByName(@RequestBody String assoName){
        return Result.succ(coreAssoService.search(assoName));
    }

}
