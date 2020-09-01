package com.protecthair.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author by liuquan
 * @Classname ModifyVO
 * @Description TODO
 * @Date 2020/8/19 23:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyVO {

    private Integer userId;

    //手机号码，可以修改，不可以重复
    @NotBlank(message = "手机号码不能为空")
    private String userPhoneNumber;
}
