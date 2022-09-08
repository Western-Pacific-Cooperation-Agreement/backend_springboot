package com.wpca.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wpca.common.dto.SysMenuDto;
import com.wpca.entity.SysMenu;
import com.wpca.entity.SysUser;
import com.wpca.mapper.SysMenuMapper;
import com.wpca.mapper.SysUserMapper;
import com.wpca.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wpca.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WPCA
 * @since 2022-09-04
 */
@Service

public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public List<SysMenuDto> getCurrentUserNav() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser sysUser = sysUserService.getByUsername(username);
        System.out.println(username);

        List<Long> menuIds=sysUserMapper.getNavMenuIds(sysUser.getId());
        List<SysMenu> menus=this.listByIds(menuIds);
        System.out.println(menuIds);
        System.out.println(menus);
        //转树状结构
        List<SysMenu> menuTree = buildTreeMenu(menus);
        //实体转DTO
        return   convert(menuTree);
    }

    @Override
    public List<SysMenu> tree() {
        List<SysMenu> sysMenus =this.list(new QueryWrapper<SysMenu>().orderByAsc("menu_orderNum"));
        return  buildTreeMenu(sysMenus);
    }

    private List<SysMenuDto> convert(List<SysMenu> menuTree) {
        List<SysMenuDto> menuDtos=new ArrayList<>();

        menuTree.forEach(m->{
            SysMenuDto dto =new SysMenuDto();
            dto.setId(m.getId());

            dto.setName(m.getMenuPerms());

            dto.setIcon(m.getMenuIcon());
            dto.setTitle(m.getMenuName());

            dto.setComponent(m.getMenuComponent());
            dto.setPath(m.getMenuPath());

            if(m.getChildren().size()>0){
                //子节点调用当前方法再次转换
                dto.setChildren(convert(m.getChildren()));
            }
            menuDtos.add(dto);
        });
        return menuDtos;
    }

    private List<SysMenu> buildTreeMenu(List<SysMenu> menus) {
        List<SysMenu> finalMenus = new ArrayList<>();

        //循环获取
        for (SysMenu menu:menus){
            for(SysMenu e: menus){
                if(menu.getId() == e.getParentId()){
                    menu.getChildren().add(e);

                }
            }
            //提取取出父节点  没有子情况
            if(menu.getParentId()==0L){
                finalMenus.add(menu);
            }

        }
        JSONUtil.toJsonStr(finalMenus);


        return finalMenus;
    }
}
