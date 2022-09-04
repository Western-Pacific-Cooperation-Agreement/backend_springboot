package com.wpca.entity;

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
public class ExpansionComment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 评论活动
     */
    private Long actId;

    /**
     * 用户评论
     */
    private String userComment;


}
