package com.wpca.service.impl;

import com.wpca.entity.CoreAct;
import com.wpca.mapper.CoreActMapper;
import com.wpca.service.CoreActService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WPCA
 * @since 2022-09-09
 */
@Service
public class CoreActServiceImpl extends ServiceImpl<CoreActMapper, CoreAct> implements CoreActService {
    /*
     * lsy
     * 获取所有活动
     * */
    public List<CoreAct> getAllAct() {
        return list();
    }

    /*
     * lsy
     * 传入活动实体,查找活动
     * */
    public List<CoreAct> getActByAct(CoreAct coreAct) {
        return getAllAct();
    }
}
