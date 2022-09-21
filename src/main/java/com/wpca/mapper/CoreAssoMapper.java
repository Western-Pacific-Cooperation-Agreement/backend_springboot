package com.wpca.mapper;

import com.wpca.entity.CoreAsso;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WPCA
 * @since 2022-09-04
 */
public interface CoreAssoMapper extends BaseMapper<CoreAsso> {
    //通过协会名称查找数据
    public CoreAsso findDataByAssoName(String name);
}
