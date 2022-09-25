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
    @Autowired
    CoreAssoMapper coreAssoMapper;

    @Override
    public List<CoreAsso> findAll(CoreAsso coreAsso) {
        return coreAssoMapper.findAll(coreAsso);
    }

    @Override
    public void delById(Integer id) {
        coreAssoMapper.deleteById(id);
    }

    @Override
    public void addCoreAsso(String assoName, Long assotypeId, Integer assoNumber) {
        coreAssoMapper.addCoreAsso(assoName,assotypeId,assoNumber);
    }

    @Override
    public List<CoreAsso> search(String assoName) {
        return coreAssoMapper.search(assoName);
    }
}
