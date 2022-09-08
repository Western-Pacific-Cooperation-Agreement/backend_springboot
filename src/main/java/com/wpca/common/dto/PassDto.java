package com.wpca.common.dto;

import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
/**
 * @author WPCA-XieQijiang
 * @Pcakage com.wpca.common.dto.PassDot
 * @Date 2022年09月07日 07:04
 * @Description
 */
@Data
public class PassDto implements Serializable {

    @NotBlank(message = "新密码不能为空")
    private String password;

    @NotBlank(message = "新密码不能为空")
    private String currentPass;



}
