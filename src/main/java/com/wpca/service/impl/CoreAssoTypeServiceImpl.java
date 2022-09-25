package com.wpca.service.impl;

import com.wpca.entity.CoreAssoType;
import com.wpca.mapper.CoreAssoTypeMapper;
import com.wpca.service.CoreAssoTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CoreAssoTypeServiceImpl extends ServiceImpl<CoreAssoTypeMapper, CoreAssoType> implements CoreAssoTypeService {
    @Autowired
    CoreAssoTypeMapper coreAssoTypeMapper;

    @Override
    public void addAssoType(String assoTypeName,String assoTypeRemark) {
        coreAssoTypeMapper.addAssoType(assoTypeName,assoTypeRemark);
    }

    @Override
    public List<CoreAssoType> search(String assoTypeName) {
        return coreAssoTypeMapper.search(assoTypeName);

    }
}
