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
public class CoreUserAct extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long actId;

    private Integer userActStatu;

    private String  userActReview;

    private LocalDateTime userActCreateTime;

    private LocalDateTime userActReviewDate;


}
