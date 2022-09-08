package com.wpca.service;

import com.wpca.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WPCA
 * @since 2022-09-04
 */
public interface SysRoleService extends IService<SysRole> {
    List<SysRole> listRolesByUserId(Long userId);
}
