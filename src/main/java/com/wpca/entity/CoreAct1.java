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
 * @since 2022-09-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CoreAct1 extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 活动名称
     */
    private String actName;

    /**
     * 社团id
     */
    private Long assoId;

    /**
     * 申请负责人用户id
     */
    private Long userId;

    /**
     * 活动地点
     */
    private String actPlace;

    /**
     * 活动性质编码
     */
    private Long actNatureId;

    /**
     * 活动人数
     */
    private Integer actNumber;

    /**
     * 活动对象id
     */
    private Long actObjectId;

    /**
     * 活动经费
     */
    private Integer actFund;

    /**
     * 申请日期
     */
    private LocalDateTime actApplyDate;

    /**
     * 审核人
     */
    private Long actReviewerId;

    /**
     * 审核日期
     */
    private Long actReviewerDate;

    /**
     * 申请审核状态（0未审核，1审核成功，2活动进行报名3，活动截止报名4、审核失败）
     */
    private Integer actReviewerStaus;

    /**
     * (0院级、1校级、2省级、3国家级、4国际级、5其他)
     */
    private Integer actGradeId;

    /**
     * （0人工审核、1系统通过自动审核）
     */
    private Integer reviewId;


}
