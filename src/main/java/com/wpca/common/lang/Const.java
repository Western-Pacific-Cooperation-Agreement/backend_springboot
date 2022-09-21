package com.wpca.common.lang;

/**
 * @author WPCA-XieQijiang
 * @Pcakage com.wpca.common.lang.Const
 * @Date 2022年09月07日 07:10
 * @Description  存储常量
 */
public class Const {
    /**
    *redis配置验证码key常量
     */
    public static final String captcha_KEY = "captcha";





    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "111111";

    /**
     * 默认头像
     */
    public static final String DEFAULT_AVATAR = "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png";


//***************************状态常量***********
    /**
     * 状态默认开启
     */
    public static final Integer STATUS_ON =  1;


    /**
     * 状态关闭
     */
    public static final Integer Forbidden =  0;


    /*****************------------用户报名常量----------------*********/
    /**
     *用户报名常量:未审核
     */
    public static final Integer USERACT_NotReview = 0;
    /**
     *用户报名常量:报名成功
     */
    public static final Integer USERACT_ReviewSuccess = 1;
    /**
     *用户报名常量:报名失败
     */
    public static final Integer USERACT_Reviewfailure = 2;
    /**
     *用户报名常量:存档
     */
    public static final Integer USERACT_Save = 3;
    /**
     *用户报名常量:报名通过了但是没有参加
     */
    public static final Integer USERACT_NotParticipate = 4;

    /****************************-------活动常量--------******************************/
    /**
     *活动常量:未审核
     */
    public static final Integer ACT_NotReview = 0;
    /**
     *用户报名常量:报名中
     */
    public static final Integer ACT_SigningUp = 1;
    /**
     *用户报名常量:结束报名
     */
    public static final Integer ACT_End= 2;
    /**
     *用户报名常量:存档
     */
    public static final Integer ACT_Save = 3;
    /**
     *用户报名常量:存档
     */
    public static final Integer ACT_Reviewfailure = 4;


}
