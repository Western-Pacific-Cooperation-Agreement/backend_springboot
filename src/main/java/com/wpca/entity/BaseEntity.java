package com.wpca.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @title: BaseEntity
 * @Author WPCA-Huang Jinpo
 * @Date: 2022/9/4 16:32
 * @Version 1.0
 */

@Data
public class BaseEntity implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;


}
