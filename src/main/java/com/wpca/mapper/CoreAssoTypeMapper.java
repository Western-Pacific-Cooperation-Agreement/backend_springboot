package com.wpca.mapper;

import com.wpca.entity.CoreAssoType;
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
public interface CoreAssoTypeMapper extends BaseMapper<CoreAssoType> {

    void addAssoType(String assoTypeName, String assoTypeRemark);

    List<CoreAssoType> search(String assoTypeName);
}
