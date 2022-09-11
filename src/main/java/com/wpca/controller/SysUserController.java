package com.wpca.controller;


import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wpca.common.lang.Const;
import com.wpca.common.lang.Result;
import com.wpca.common.dto.PassDto;
import com.wpca.entity.SysRole;
import com.wpca.entity.SysUser;
import com.wpca.entity.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('sys:user:list')")
    public Result info(@PathVariable Long id) {
        SysUser user = sysUserService.getById(id);
        Assert.notNull(user, "找不到该管理员！");
        List<SysRole> roles = sysRoleService.listRolesByUserId(user.getId());
        user.setRoles(roles);
        return Result.succ(user);
    }

    /**
     * 用户自己修改密码
     *
     */
    @PostMapping("/updataPass")
    public Result updataPass(@Validated @RequestBody PassDto passDto, Principal principal) {
        SysUser sysUser = sysUserService.getByUsername(principal.getName());
        boolean matches = passwordEncoder.matches(passDto.getCurrentPass(), sysUser.getPassword());
        if (!matches) {
            return Result.fail("旧密码不正确！");
        }
        sysUser.setPassword(passwordEncoder.encode(passDto.getPassword()));
        sysUser.setUpdateTime(LocalDateTime.now());
        sysUserService.updateById(sysUser);
        return Result.succ(null);
    }

    /**
     * 超级管理员重置密码
     */
    @PostMapping("/repass")
    @PreAuthorize("hasAuthority('sys:user:repass')")
    public Result repass(@RequestBody Long userId) {
        SysUser sysUser = sysUserService.getById(userId);
        sysUser.setPassword(passwordEncoder.encode(Const.DEFAULT_PASSWORD));
        sysUser.setUpdateTime(LocalDateTime.now());
        sysUserService.updateById(sysUser);
        return Result.succ(null);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sys:user:list')")
    public Result page(String username) {


        Page<SysUser> users = sysUserService.page(getPage(),
                new QueryWrapper<SysUser>()
                        .like(StrUtil.isNotBlank(username), "username", username)
        );

        //获得用户的角色id
        users.getRecords().forEach(u -> {
            u.setRoles(sysRoleService.listRolesByUserId(u.getId()));
        });


        return Result.succ(users);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sys:user:save')")
    public Result save(@Validated @RequestBody SysUser sysUser) {
        sysUser.setCreateTime(LocalDateTime.now());
        sysUser.setUserStatu(Const.STATUS_ON);
        // 初始默认密码
        sysUser.setPassword(Const.DEFAULT_PASSWORD);
        if (StrUtil.isBlank(sysUser.getPassword())) {
            return Result.fail("密码不能为空");
        }
        String password = passwordEncoder.encode(sysUser.getPassword());
        sysUser.setPassword(password);
        // 默认头像
        sysUser.setAvatar(Const.DEFAULT_AVATAR);
        sysUserService.save(sysUser);
        return Result.succ(sysUser);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys:user:update')")
    public Result update(@Validated @RequestBody SysUser sysUser) {
        sysUser.setUpdateTime(LocalDateTime.now());
        if (StrUtil.isNotBlank(sysUser.getPassword())) {
            String password = passwordEncoder.encode(sysUser.getPassword());
            sysUser.setPassword(password);
        }
        sysUserService.updateById(sysUser);
        return Result.succ(sysUser);
    }

    @PostMapping("/delete")
    //@PreAuthorize("hasAuthority('sys:user:delete')")
    public Result delete(@RequestBody Long[] ids){
        sysUserService.removeByIds(Arrays.asList(ids));
        sysUserRoleService.remove(new QueryWrapper<SysUserRole>().in("user_id", ids));
        return Result.succ("");
    }

    /**
     * 分配角色
     * @return
     */
    @Transactional
    @PostMapping("/role/{userId}")
    //@PreAuthorize("hasAuthority('sys:user:role')")
    public Result perm(@PathVariable Long userId, @RequestBody Long[] roleIds) {
        System.out.println(roleIds);
        List<SysUserRole> userRoles = new ArrayList<>();
        Arrays.stream(roleIds).forEach(roleId -> {
            SysUserRole userRole = new SysUserRole();
            userRole.setRoleId(roleId);
            userRole.setUserId(userId);
            userRoles.add(userRole);
        });
        sysUserRoleService.remove(new QueryWrapper<SysUserRole>().eq("user_id", userId));
        sysUserRoleService.saveBatch(userRoles);
        // 清除权限信息
        SysUser sysUser = sysUserService.getById(userId);
        sysUserService.clearUserAuthorityInfo(sysUser.getUsername());
        return Result.succ(roleIds);
    }
}

