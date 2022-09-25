package com.wpca.service.impl;

import com.wpca.entity.CoreActGrade;
import com.wpca.mapper.CoreActGradeMapper;
import com.wpca.service.CoreActGradeService;
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
public class CoreActGradeServiceImpl extends ServiceImpl<CoreActGradeMapper, CoreActGrade> implements CoreActGradeService {

    @Autowired
    CoreActGradeMapper coreActGradeMapper;

    @Override
    public List<CoreActGrade> findAll() {
        return coreActGradeMapper.findAll();
    }

    @Override
    public List<CoreActGrade> getActTypeByName(String actGradeName) {
        return coreActGradeMapper.getActTypeByName(actGradeName);
    }

    @Override
    public void delById(Integer id) {
        coreActGradeMapper.delById(id);
    }

    @Override
    public void updateActType(CoreActGrade coreActGrade) {
        coreActGradeMapper.updateActType(coreActGrade);
    }

    @Override
    public void saveActType(String actGradeName,String actGradeRemark) {
        coreActGradeMapper.saveActType(actGradeName,actGradeRemark);
    }
}
