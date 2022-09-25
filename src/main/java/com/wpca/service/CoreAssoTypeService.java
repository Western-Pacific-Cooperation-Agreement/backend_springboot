package com.wpca.service;

import com.wpca.entity.CoreAssoType;
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
public interface CoreAssoTypeService extends IService<CoreAssoType> {

    void addAssoType(String assoTypeName,String assoTypeRemark);

    List<CoreAssoType> search(String assoTypeName);
}
