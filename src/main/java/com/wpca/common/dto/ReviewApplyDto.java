package com.wpca.common.dto;

import com.wpca.entity.CoreAct;
import com.wpca.entity.CoreUserAct;
import com.wpca.entity.SysUser;
import lombok.Data;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.common.dto.ReviewApply
 * @Date 2022年09月25日 08:03
 * @Description
 */

@Data
public class ReviewApplyDto {

    CoreUserAct CoreUserAct;

    SysUser sysUser;


}
