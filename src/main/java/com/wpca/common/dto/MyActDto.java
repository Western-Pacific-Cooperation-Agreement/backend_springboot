package com.wpca.common.dto;

import com.wpca.entity.CoreAct;
import com.wpca.entity.CoreUserAct;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.common.dto.MyAct
 * @Date 2022年09月12日 07:39
 * @Description
 */

@Data
public class MyActDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long actId;

    private Integer userActStatu;

    private String  userActReview;

    private LocalDateTime userActCreateTime;

    private LocalDateTime userActReviewDate;

    private CoreAct coreAct;





}
