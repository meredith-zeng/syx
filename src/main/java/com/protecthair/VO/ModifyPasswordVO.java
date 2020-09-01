package com.protecthair.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author by liuquan
 * @Classname ModifyPasswordVO
 * @Description TODO
 * @Date 2020/8/19 23:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyPasswordVO {
    @NotBlank(message = "旧密码不为空")
    private String userPassword;
    @NotBlank(message = "新密码不为空")
    private String newPasswprd;
    @NotNull(message = "验证码不为空")
    private Integer msgCode;
}
