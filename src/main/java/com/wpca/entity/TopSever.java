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
public class TopSever extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主机名
     */
    private String severName;

    /**
     * 主机ip地址
     */
    private String severUrl;

    /**
     * CPU核心
     */
    private String severCpu;

    /**
     * 内存大小
     */
    private String severMemory;

    /**
     * 主机地区
     */
    private String severRegion;

    /**
     * 主机类型
     */
    private Long severHostTypeId;

    /**
     * 主机端口
     */
    private Integer severPort;

    /**
     * x坐标
     */
    private Double xPosition;

    /**
     * y坐标
     */
    private Double yPosition;


}
