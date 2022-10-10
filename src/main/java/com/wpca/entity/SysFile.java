package com.wpca.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author WPCA
 * @since 2022-10-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysFile extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件类型
     */
    private String type;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 下载链接
     */
    private String url;
    /**
     * 下载链接
     */
    private String md5;


    /**
     * 是否删除
     */
    private Boolean isDelete;

    /**
     * 是否可用
     */
    private Boolean enable;


}
