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
public class TopHostLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主机
     */
    private Long hostId;

    /**
     * 服务器
     */
    private Long serverId;

    /**
     * 日期
     */
    private LocalDateTime serveDate;


}
