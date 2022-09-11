package com.wpca.entity;

import java.time.LocalDateTime;

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
public class TopServerLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主机
     */
    private Long serverId;

    /**
     * 平均负载百分比
     */
    private Double serverLogAverage;

    /**
     * 日期
     */
    private LocalDateTime serverLogDate;


}
