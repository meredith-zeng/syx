package com.protecthair.domain;

import com.protecthair.vo.ModifyVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by liuquan
 * @Classname User
 * @Description TODO
 * @Date 2020/8/29 14:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String universityCode;
    private String userPassword;
    private String userPhoneNumber;
    private String userSalt;

    public User(ModifyVO modifyVO, Integer userId) {

    }

    public User(String newPassword, String universityCode) {

    }

    public User(int i, String s) {
        this.userId = i;
        this.setUserPhoneNumber(s);
    }
}
