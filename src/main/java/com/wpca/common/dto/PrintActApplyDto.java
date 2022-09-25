package com.wpca.common.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.common.dto.PrintActApplyDto
 * @Date 2022年09月18日 20:26
 * @Description 打印厦门理工学院活动登记卡Dto
 */

@Data
public class PrintActApplyDto {

    /******************************************************** 打印位置1
    /**
     * 社团id
     */
    private Long assoId;
    /***
     * 社团id
     */
    private String assoName;

    private String assoType;
    /***************************************************************************


     /***************************************************************************

     /**
     * 申请负责人用户id
     */
    private Long userId;
    /**
     * 申请负责人用户id
     */
    private String applyUserPhone;

    /***************************************************************************



    /**********************************************************************************************

    /**
     * 活动地点
     */
    private String actPlace;
    /**********************************************************************************************




     /***********************************************************************************
     /**
     * 审核人
     */
    private Long actReviewerId;
    /**
     * 审核人电话
     */
    private String reviewPhone;

    /***********************************************************************************


     /****************************************************************************
     /**
     * 活动对象id
     */
    private Long actObjectId;

    private String actObjectName;

     /****************************************************************************



      /****************************************************************************
      /**
      * 活动人数
      */
     private Integer actNumber;

     private String actNumberName;
    /****************************************************************************




     /****************************************************************************


     /**
     * 活动名称
     */
    private String actName;



    /****************************************************************************


     /****************************************************************************
     /**
     * 活动目的
     */
    private String actAim;

    /****************************************************************************

    /**
     * 活动性质编码
     */
    private Long actNatureId;


    /******************************************************************

    /**
     * 活动经费
     */
    private Integer actFund;

    /******************************************************************

    /**
     * 申请日期
     */
    private LocalDateTime actApplyDate;


    /**
     * 审核日期
     */
    private LocalDateTime actReviewerDate;


    /**
     * 申请审核状态（0未审核，1审核成功，2活动进行报名3，活动截止报名4、审核失败）
     */
    private Integer actReviewerStaus;


    /**
     * (0院级、1校级、2省级、3国家级、4国际级、5其他)
     */
    private Long actGradeId;


    /**
     * （0人工审核、1系统通过自动审核）
     */
    private Long reviewId;


    /**
     * 图片
     */
    private String actUrl;



    /**
     * 指导人
     */
    private Long actGuideUserid;

    /**
     * 活动时间时长
     */
    private String actDuration;

    /**
     * 活动内容
     */
    private String actMessage;

    /**
     * 活动流程
     */
    private String actProcess;

    /**
     * 注意事项
     */
    private String actWarn;



    /**
     * 审核回复
     */
    private String actReply;



    /**
     * 活动积分
     */
    private Long actIntegral;


    /**
     * 活动开始时间
     */
    private LocalDateTime actStartDate;





}
