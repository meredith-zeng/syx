package com.protecthair.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author by liuquan
 * @Classname LoginVo
 * @Description 登录的VO
 * @Date 2020/8/11 15:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVo {
    @NotBlank(message = "统一验证码不为空")
    private String universityCode;
    @NotBlank(message = "密码不为空")
    private String userPassword;
}
