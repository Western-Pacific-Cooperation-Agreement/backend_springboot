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
public class CoreReview extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 审核级别名
     */
    private String reviewName;

    /**
     * 备注 
     */
    private String reviewRemark;


}
