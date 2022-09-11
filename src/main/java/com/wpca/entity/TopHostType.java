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
public class TopHostType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主机
     */
    private Long hostId;

    /**
     * 主机名
     */
    private String hostNameType;

    /**
     * 备注
     */
    private String hostRemark;


}
