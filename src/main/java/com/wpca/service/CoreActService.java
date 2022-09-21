package com.wpca.service;

import com.wpca.entity.CoreAct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WPCA
 * @since 2022-09-09
 */
public interface CoreActService extends IService<CoreAct> {
    /*
     * lsy
     * 获取所有活动
     * */
    public List<CoreAct> getAllAct();

    /*
     * lsy
     * 传入活动实体,查找活动
     * */
    public List<CoreAct> getActByAct(CoreAct coreAct);
}
