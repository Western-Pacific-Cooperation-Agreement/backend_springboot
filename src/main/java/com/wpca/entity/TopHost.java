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
public class TopHost extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主机名
     */
    private String hostName;

    /**
     * 主机ip地址
     */
    private String hostUrl;


}
