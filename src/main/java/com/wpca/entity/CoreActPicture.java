package com.wpca.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author WPCA
 * @since 2022-09-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CoreActPicture extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 活动
     */
    private Long act_id;

    /**
     * 图片名
     */
    private String actPictureName;

    /**
     * 图片地址
     */
    private String base;


}
