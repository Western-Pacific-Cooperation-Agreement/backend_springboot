package com.wpca.service.impl;

import com.wpca.entity.CoreAsso;
import com.wpca.mapper.CoreAssoMapper;
import com.wpca.service.CoreAssoService;
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
public class CoreAssoServiceImpl extends ServiceImpl<CoreAssoMapper, CoreAsso> implements CoreAssoService {


    @Override
    public List<CoreAsso> findAll(CoreAsso coreAsso) {
        return null;
    }

    @Override
    public void delById(Long id) {

    }
}
