package com.wpca.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class ExpansionCertification extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 认证码
     */
    @TableField("certification_Code")
    private String certificationCode;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 认证对象类型
     */
    private Long roleId;

    /**
     * 状态
     */
    private Integer certificationStatu;


}
