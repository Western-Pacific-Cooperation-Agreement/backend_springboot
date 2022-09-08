package com.wpca.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  WPCA-XieQijiang
 * @Pcakage com.wpca.common.dto.SysMenuDto
 * @Date 2022年09月07日 07:05
 * @Description 菜单返回模板
 */
@Data //生成get set
public class SysMenuDto implements Serializable {

    private Long id;
    private String name;
    private String title;
    private String icon;
    private String path;
    private String component;
    private List<SysMenuDto> children = new ArrayList<>();



}
