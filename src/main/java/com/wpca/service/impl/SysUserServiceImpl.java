package com.wpca.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wpca.entity.SysMenu;
import com.wpca.entity.SysRole;
import com.wpca.entity.SysUser;
import com.wpca.mapper.SysUserMapper;
import com.wpca.service.SysMenuService;
import com.wpca.service.SysRoleService;
import com.wpca.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wpca.ultis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WPCA
 * @since 2022-09-04
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    SysUserMapper sysUserMapper;


    @Autowired
    SysMenuService sysMenuService;

    @Autowired
    RedisUtil redisUtil;


    @Override
    public SysUser getByUsername(String username) {
        log.info("检验markhub:"+getOne(new QueryWrapper<SysUser>().eq("username","admin")));
        log.info("查表用户名："+username);
        return getOne(new QueryWrapper<SysUser>().eq("username",username));
    }

    @Override
    public String getUserAuthorityInfo(Long userId) {





        SysUser sysUser = sysUserMapper.selectById(userId);

        //ROLE_admin，ROLE_normal,sys:user:list.......
        String authority="";

        if(redisUtil.hasKey("GrantedAuthority:"+sysUser.getUsername())){
            authority=(String)redisUtil.get("GrantedAuthority:"+sysUser.getUsername());

        }else {

            //h获取角色
            List<SysRole> roles = sysRoleService.list(new QueryWrapper<SysRole>()
                    .inSql("id", "select role_id from sys_user_role where user_id=" + userId));

            if (roles.size() > 0) {
                String roleCodes = roles.stream().map(r -> "ROLE_" + r.getRoleCode()).collect(Collectors.joining(","));
                authority = roleCodes.concat(",");
            }
            //获取操作编码

            List<Long> menuIds = sysUserMapper.getNavMenuIds(userId);

            if (menuIds.size() > 0) {
                List<SysMenu> menus = sysMenuService.listByIds(menuIds);
                String menuPerms = menus.stream().map(m -> m.getMenuPerms()).collect(Collectors.joining(","));

                authority = authority.concat(menuPerms);
            }

            redisUtil.set("GrantedAuthority:" + sysUser.getUsername(), authority, 60 * 60);

        }

        return authority;
    }

    @Override
    public void clearUserAuthorityInfo(String username) {
        redisUtil.del("GrantedAuthority:" + username);
    }

    @Override
    public void clearUserAuthorityInfoByRoleId(Long roleId) {
        List<SysUser> sysUsers = this.list(new QueryWrapper<SysUser>()
                .inSql("id", "select user_id from sys_user_role where role_id=" + roleId));

        sysUsers.forEach(u ->{
            this.clearUserAuthorityInfo(u.getUsername());
        });
    }

    @Override
    public void clearUserAuthorityInfoByMenuId(Long menuId) {
        List<SysUser>sysUsers=sysUserMapper.listByMenuId(menuId);
        sysUsers.forEach(u ->{
            this.clearUserAuthorityInfo(u.getUsername());
        });
    }
}
