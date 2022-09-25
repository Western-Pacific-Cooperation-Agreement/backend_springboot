package com.wpca.mapper;

import com.wpca.entity.CoreActGrade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WPCA
 * @since 2022-09-04
 */
@Mapper
public interface CoreActGradeMapper extends BaseMapper<CoreActGrade> {

    List<CoreActGrade> findAll();

    List<CoreActGrade> getActTypeByName(String actGradeName);

    void delById(Integer id);

    void updateActType(CoreActGrade coreActGrade);

    void saveActType(String actGradeName, String actGradeRemark);
}
