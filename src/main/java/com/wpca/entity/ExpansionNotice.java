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
 * @since 2022-09-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ExpansionNotice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 公告名
     */
    private String noticeName;

    /**
     * 公告内容
     */
    private String noticeMessage;

    /**
     * 时间
     */
    private LocalDateTime noticeTime;


}
