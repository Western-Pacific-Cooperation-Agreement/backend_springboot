package com.wpca.controller;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wpca.common.dto.SysMenuDto;
import com.wpca.common.lang.Const;
import com.wpca.common.lang.Result;
import com.wpca.entity.SysMenu;
import com.wpca.entity.SysRoleMenu;
import com.wpca.entity.SysUser;
import com.wpca.service.SysRoleMenuService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import com.wpca.service.SysMenuService;
import com.wpca.service.SysUserService;

import org.springframework.beans.factory.annotation.Autowired;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WPCA
 * @since 2022-09-04
 */

@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {


    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysMenuService sysMenuService;

    @Autowired
    SysRoleMenuService sysRoleMenuService;

    @GetMapping("/nav")
    public Result nav(Principal principal){
        SysUser sysUser = sysUserService.getByUsername(principal.getName());


        //获取权限信息
        String authorityInfo = sysUserService.getUserAuthorityInfo(sysUser.getId());
        String[] strings = StringUtils.tokenizeToStringArray(authorityInfo, ","); //讲逗号隔开转化成数组

        //获取导航栏信息
        List<SysMenuDto> navs=sysMenuService.getCurrentUserNav();



        return Result.succ(
                MapUtil.builder()
                        .put("authoritys",strings)
                        .put("navs",navs)
                        .map()
        );


    }

    @GetMapping("/info/{id}")
//    @PreAuthorize("hasAuthority('sys:menu:list')")
    public Result info(@PathVariable("id") Long id) {
        return Result.succ(sysMenuService.getById(id));
    }

    @GetMapping("/list")
    //@PreAuthorize("hasAuthority('sys:menu:list')")
    public Result list() {
        List<SysMenu> menus = sysMenuService.tree();
        return Result.succ(menus);
    }

    @PostMapping("/save")
    //@PreAuthorize("hasAuthority('sys:menu:save')")
    public Result save(@Validated @RequestBody SysMenu sysMenu) {
        sysMenu.setCreateTime(LocalDateTime.now());
        sysMenu.setMenuStatu(Const.STATUS_ON);
        sysMenuService.save(sysMenu);
        return Result.succ(sysMenu);
    }

    @PostMapping("/update")
    //@PreAuthorize("hasAuthority('sys:menu:update')")
    public Result update(@Validated @RequestBody SysMenu sysMenu) {
        sysMenu.setUpdateTime(LocalDateTime.now());
        sysMenuService.updateById(sysMenu);
        // 清除所有与该菜单相关的权限缓存
        sysUserService.clearUserAuthorityInfoByMenuId(sysMenu.getId());
        return Result.succ(sysMenu);
    }

    @Transactional
    @PostMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('sys:menu:delete')")
    public Result delete(@PathVariable Long id) {
        int count = sysMenuService.count(new QueryWrapper<SysMenu>().eq("parent_id", id));
        if (count > 0) {
            return Result.fail("请先删除子菜单");
        }
        // 先清除所有与该菜单相关的权限缓存
        sysUserService.clearUserAuthorityInfoByMenuId(id);
        sysMenuService.removeById(id);
        // 同步删除
        sysRoleMenuService.remove(new QueryWrapper<SysRoleMenu>().eq("menu_id", id));
        return Result.succ("");
    }
}
