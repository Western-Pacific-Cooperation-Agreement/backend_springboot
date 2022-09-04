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
public class CoreAct2 extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long actId;


}
