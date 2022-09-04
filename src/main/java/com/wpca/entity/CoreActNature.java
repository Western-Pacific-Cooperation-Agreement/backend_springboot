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
public class CoreActNature extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 活动性质名称
     */
    private String actNatureName;

    /**
     * 审核级别 
     */
    private Long actReviewId;

    /**
     * 备注
     */
    private String actNatureRemark;


}
