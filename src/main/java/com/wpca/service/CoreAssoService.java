package com.wpca.service;

import com.wpca.entity.CoreAsso;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import com.wpca.entity.CoreAsso;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WPCA
 * @since 2022-09-04
 */

public interface CoreAssoService extends IService<CoreAsso> {
    public List<CoreAsso> findAll(CoreAsso coreAsso);

    void delById(Integer id);

    void addCoreAsso(String assoName, Long assotypeId, Integer assoNumber);

    List<CoreAsso> search(String assoName);


}
