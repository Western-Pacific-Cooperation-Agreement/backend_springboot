package com.wpca.mapper;

import com.wpca.entity.CoreAct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WPCA
 * @since 2022-09-09
 */
@Repository
public interface CoreActMapper extends BaseMapper<CoreAct> {
   List<CoreAct> getActBySql(String sql);

}
