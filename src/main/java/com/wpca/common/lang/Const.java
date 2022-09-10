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
     * 状态默认开启
     */
    public static final Integer STATUS_ON =  1;


    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "111111";

    /**
     * 默认头像
     */
    public static final String DEFAULT_AVATAR = "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png";




    /*****************------------用户报名常量----------------*********/
    /**
     *用户报名常量:未审核
     */
    public static final Integer USERACT_NotReview = 0;
    /**
     *用户报名常量:审核成功
     */
    public static final Integer USERACT_ReviwSuccess = 1;
    /**
     *用户报名常量:审核失败
     */
    public static final Integer USERACT_Reviwfailure = 2;
    /**
     *用户报名常量:存档
     */
    public static final Integer USERACT_Save = 3;
    /**
     *用户报名常量:报名通过了但是没有参加
     */
    public static final Integer USERACT_NotParticipate = 4;




}
