package com.protecthair.controller;

import com.aliyuncs.exceptions.ClientException;
import com.protecthair.vo.LoginVo;
import com.protecthair.vo.ModifyPasswordVO;
import com.protecthair.vo.ModifyVO;
import com.protecthair.domain.SessionUser;
import com.protecthair.domain.User;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Constant;
import com.protecthair.result.Result;
import com.protecthair.services.UserServices;
import com.protecthair.util.AliyunSmsUtils;
import com.protecthair.util.SessionUtil;
import com.protecthair.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author by liuquan
 * @Classname UserController
 * @Description TODO
 * @Date 2020/8/29 14:31
 */

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    UserServices userServices;

    //用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result userLogin( @Validated LoginVo loginVo,
                            HttpServletResponse response, HttpSession session) {
        Result<SessionUser> res = userServices.login(loginVo);
        //登录成功
        if (res.getCode()==3103) {
            String token = UUIDUtil.uuid();
            //存储session
            SessionUser sessionUser = res.getData();
            session.setAttribute(token,sessionUser);
            Cookie cookie = new Cookie(Constant.COOKIE_TOKEN_NAME, token);
            cookie.setMaxAge(3600 * 6);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return res;
    }

    //修改用户信息
    @RequestMapping(value = "/modifyMsg", method = RequestMethod.POST)
    public Result modifyUserMsg( @Validated ModifyVO modifyVO,
                                HttpServletRequest request) {
        //获取sessionid
        SessionUser sessionUser = SessionUtil.getSessionUserFromCookie(request);
        Integer userId = sessionUser.getUser().getUserId();
        modifyVO.setUserId(userId);
        CodeMsg codeMsg = userServices.modifyUser(modifyVO);
        return Result.CodeMsg(codeMsg);
    }

    //修改用户密码
    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
    public Result modifyUserPassword( @Validated ModifyPasswordVO modifyPasswordVO,
                                     HttpServletRequest request) {
        //验证码失效检验
        User user = SessionUtil.getSessionUserFromCookie(request).getUser();
        String token = SessionUtil.getStringFromCookie(request);
        String phone = user.getUserPhoneNumber();
        String universityCode = user.getUniversityCode();

        Date date = (Date) request.getSession().getAttribute(phone + "_time");
        if (date == null) {
            //验证码没有发送
            return Result.error(CodeMsg.MESSAGE_NOT_SEND);
        } else if ((System.currentTimeMillis() - date.getTime()) / 1000 >= 60) {
            //验证码发送超时
            return Result.error(CodeMsg.MESSAGE_LOST_USE);
        } else {//验证码正常发送,修改完之后退出登录
            Integer code = (Integer) request.getSession().getAttribute("aliyun_message");
            CodeMsg msg = userServices.modifyUserPassword(universityCode, modifyPasswordVO, code);
            //删除session
            request.getSession().invalidate();
            request.getSession().removeAttribute(token);
            return Result.CodeMsg(msg);
        }
    }

    //登出功能
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        //获取token
        String token = SessionUtil.getStringFromCookie(request);
        request.getSession().removeAttribute(token);
        request.getSession().invalidate();
        //重定向到首页
        return "redirect:/pages/user/index.html";
    }


    //点击发送短信
    @RequestMapping(value = "/messageSend", method = RequestMethod.POST)
    public Result messageSendConfirm(HttpServletRequest request) throws ClientException {
        SessionUser sessionUser = SessionUtil.getSessionUserFromCookie(request);
        //获取手机号码
        String phoneNumber = sessionUser.getUser().getUserPhoneNumber();
        Date time = (Date) request.getSession().getAttribute(phoneNumber + "_time");
        //之前发送过短信
        if (time != null) {
            Long timestamp = (System.currentTimeMillis() - time.getTime()) / 1000;
            if (timestamp < 60) {
                return Result.error(CodeMsg.MESSAGE_SENDED_ERROR);
            }
        }
        //生成验证码
        AliyunSmsUtils.setNewcode();
        Integer alimsg = AliyunSmsUtils.getNewcode();
        //验证码发送
        CodeMsg msg = AliyunSmsUtils.sendSms(phoneNumber, alimsg.toString());
        //在session里面设置验证码
        request.getSession().setAttribute("aliyun_message", alimsg);
        request.getSession().setAttribute(phoneNumber + "_time", new Date());
        return Result.CodeMsg(msg);
    }

}
