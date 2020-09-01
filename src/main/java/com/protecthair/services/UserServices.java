package com.protecthair.services;

import com.protecthair.VO.LoginVo;
import com.protecthair.VO.ModifyPasswordVO;
import com.protecthair.VO.ModifyVO;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
