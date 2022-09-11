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
public class TopServerConnect extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 服务器
     */
    private Long hostId1;

    /**
     * 服务器
     */
    private Long hostId2;

    /**
     * 关联状态
     */
    private Integer hostConnectStaus;

    /**
     * 备注
     */
    private String serverConnectRemark;


}
