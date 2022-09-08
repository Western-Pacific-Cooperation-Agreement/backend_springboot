package com.wpca.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wpca.entity.SysRole;
import com.wpca.mapper.SysRoleMapper;
import com.wpca.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Override
    public List<SysRole> listRolesByUserId(Long userId) {
        return this.list(
                new QueryWrapper<SysRole>()
                        .inSql("id", "select role_id from sys_user_role where user_id = " + userId));
    }
}
