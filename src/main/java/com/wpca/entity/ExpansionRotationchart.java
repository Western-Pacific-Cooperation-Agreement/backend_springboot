package com.wpca.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author WPCA
 * @since 2022-09-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ExpansionRotationchart extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 轮播图名称
     */
    private String rotationchartName;

    /**
     * 活动
     */
    private Long actId;

    /**
     * 图片地址
     */
    private String url;


}
