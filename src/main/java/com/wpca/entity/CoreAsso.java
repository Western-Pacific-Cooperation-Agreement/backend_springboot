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
public class CoreAsso extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 协会名称
     */
    private String assoName;

    /**
     * 协会类型
     */
    private Long assotypeId;

    /**
     * 协会人数
     */
    private Integer assoNumber;


}
