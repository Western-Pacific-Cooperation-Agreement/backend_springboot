package com.wpca.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wpca.service.*;
import com.wpca.ultis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @title: BaseController
 * @Author WPCA-Huang Jinpo
 * @Date: 2022/9/4 16:31
 * @Version 1.0
 */

public class BaseController {
    @Autowired
    HttpServletRequest req;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysRoleService sysRoleService;


    @Autowired
    SysMenuService sysMenuService;


    @Autowired
    SysUserRoleService sysUserRoleService;


    @Autowired
    SysRoleMenuService sysRoleMenuService;



    public Page getPage(){

        int current= ServletRequestUtils.getIntParameter(req,"current",1);

        int size= ServletRequestUtils.getIntParameter(req,"size",10);
        return  new Page(current,size);
    }
}
