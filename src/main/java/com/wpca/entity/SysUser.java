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
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 部门协会id
     */
    private Long assoId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 城市
     */
    private String city;

    /**
     * 用户积分
     */
    private Long userIntegral;

    /**
     * 用户签名
     */
    private String userAutograph;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 最后登入
     */
    private LocalDateTime lastLogin;

    /**
     * （0无认证状态，1认证过，2审核状态，3禁用、4注销）
     */
    private Integer userStatu;


}
