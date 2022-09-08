package com.wpca.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.wpca.common.dto.SysMenuDto;
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
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单URL
     */
    private String menuPath;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String menuPerms;

    /**
     * 组件路径
     */
    private String menuComponent;

    /**
     * 类型     0：目录   1：菜单   2：按钮
     */
    private Integer menuType;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 排序
     */
    @TableField("menu_orderNum")
    private Integer menuOrdernum;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 菜单状态（0禁用，1启用）
     */
    private Integer menuStatu;

    /**
     * 前端孩子节点
     */

    @TableField(exist = false)//这里是告诉容器说 此列不存在
    private List<SysMenu> children = new ArrayList<>();


}
