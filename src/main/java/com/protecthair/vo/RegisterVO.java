package com.protecthair.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * @author by liuquan
 * @Classname RegisterVO
 * @Description TODO
 * @Date 2020/8/19 20:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterVO {

    //手机号码，可以修改，不可以重复
    @NotBlank(message = "手机号码不能为空")
    private String userPhoneNumber;

    //昵称，不可以重复，不可以修改，当作登录的账户
    @NotBlank(message = "姓名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String userPassword;

    //性别，不可以修改
    @NotBlank(message = "性别不能为空")
    private String userSexy;

    //民族，不可修改
    @NotBlank(message = "民族不能为空")
    private String userNational;

    //年龄，可以修改
    @NotNull(message = "出生日期不能为空")
    private Date birthDate;
}
