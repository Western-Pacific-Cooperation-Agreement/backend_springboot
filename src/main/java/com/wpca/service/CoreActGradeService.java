package com.wpca.service;

import com.wpca.entity.CoreActGrade;
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
public interface CoreActGradeService extends IService<CoreActGrade> {

    List<CoreActGrade> findAll();

    List<CoreActGrade> getActTypeByName(String actGradeName);

    void delById(Integer id);

    void updateActType(CoreActGrade coreActGrade);

    void saveActType(String actGradeName,String actGradeRemark);
}
