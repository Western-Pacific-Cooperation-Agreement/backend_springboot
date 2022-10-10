package com.wpca.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wpca.entity.CoreAsso;
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
public interface CoreAssoMapper extends BaseMapper<CoreAsso> {
    public List<CoreAsso> findAll(CoreAsso coreAsso);

    public void delById(Integer  id);

    void addCoreAsso(String assoName, Long assotypeId, String remark);

    List<CoreAsso> search(String assoName);
}
