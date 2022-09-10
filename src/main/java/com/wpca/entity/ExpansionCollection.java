package com.wpca.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

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
public class ExpansionCollection extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 活动
     */
    private Long actId;

    /**
     * 活动
     */
    private LocalDateTime collectionDate;

}
