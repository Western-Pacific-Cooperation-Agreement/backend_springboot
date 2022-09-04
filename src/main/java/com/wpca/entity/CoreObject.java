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
public class CoreObject extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long actId;

    /**
     * 对象名称
     */
    private String objectName;

    /**
     * 备注(0全体成员，1是部门内学生参加 2，全体学生参加 3是老师参加)
     */
    private Integer objectRemark;


}
