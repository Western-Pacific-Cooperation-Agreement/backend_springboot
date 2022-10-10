package com.wpca.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author WPCA
 * @since 2022-10-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDict extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String name;

    /**
     * 系统编码
     */
    private String syscode;

    /**
     * 描述
     */
    private String remark;

    /**
     * 用户编码
     */
    private String usercode;


}
