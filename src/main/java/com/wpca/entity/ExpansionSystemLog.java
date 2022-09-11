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
public class ExpansionSystemLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long hostId;

    private Long userId;

    private Long menuId;

    /**
     * 访问时间
     */
    private LocalDateTime visitedTime;


}
