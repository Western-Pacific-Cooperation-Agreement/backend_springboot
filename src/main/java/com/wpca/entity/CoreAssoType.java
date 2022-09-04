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
public class CoreAssoType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     *  社团类型名称
     */
    private String assoTypeName;

    /**
     * 备注
     */
    private String assoTypeRemark;


}
