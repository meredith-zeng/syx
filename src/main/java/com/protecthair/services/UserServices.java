package com.protecthair.services;

import com.protecthair.vo.LoginVo;
import com.protecthair.vo.ModifyPasswordVO;
import com.protecthair.vo.ModifyVO;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Result;

/**
 * @author by liuquan
 * @Classname UserServices
 * @Description TODO
 * @Date 2020/8/29 9:59
 */
public interface UserServices {

    Result login(LoginVo loginVo);

    CodeMsg modifyUser(ModifyVO modifyVO);

    CodeMsg modifyUserPassword(String universityCode, ModifyPasswordVO modifyPasswordVO, Integer code);

}
