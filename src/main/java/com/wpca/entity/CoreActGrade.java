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
public class CoreActGrade extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long actId;

    /**
     * 活动级别名称
     */
    private String actGradeName;

    /**
     * 备注
     */
    private String actGradeRemark;


}
