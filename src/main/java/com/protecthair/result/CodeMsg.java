package com.protecthair.result;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author by liuquan
 * @Classname CodeMsg
 * @Description code和 msg的信息，便于快速构造result
 * @Date 2020/8/10 13:05
 */
@Data
@AllArgsConstructor
public class CodeMsg {

    private int code;
    private String msg;

    //注册模块
    public static final CodeMsg REGISTER_SUCCESS = new CodeMsg(200, "注册成功");
    public static final CodeMsg REGISTER_EXIST_PHONENUMBER = new CodeMsg(201, "手机号码已经被注册");
    public static final CodeMsg REGISTER_ERROR_BIRTH = new CodeMsg(202, "错误的出生年月");
    //通用模块
    public static final CodeMsg NULL_DATA = new CodeMsg(1001, "部分数据为空");


    //日志模块
    public static final CodeMsg LOG_INSERT_SUCCESS = new CodeMsg(2001, "日志新增成功");
    public static final CodeMsg LOG_INSERT_ERROR = new CodeMsg(2002, "日志新增失败");
    public static final CodeMsg LOG_UPDATE_SUCCESS = new CodeMsg(2003, "日志修改成功");
    public static final CodeMsg LOG_UPDATE_ERROR  = new CodeMsg(2004, "日志修改失败");
    public static final CodeMsg LOG_SELECT_SUCCESS = new CodeMsg(2005, "指定团队指定日志查询成功");
    public static final CodeMsg LOG_SELECT_ERROR = new CodeMsg(2006, "指定团队指定日志查询失败");
    public static final CodeMsg LOG_SELECT_ALL_SUCCESS = new CodeMsg(2007, "指定团队所有日志查询成功");
    public static final CodeMsg LOG_SELECT_ALL_ERROR = new CodeMsg(2008, "指定团队所有日志查询失败");
    public static final CodeMsg LOG_QUERY_SUCCESS = new CodeMsg(2009, "查询所有团队所有日志成功");
    public static final CodeMsg LOG_QUERY_ERROR = new CodeMsg(2010, "查询所有团队所有日志失败");
    //动态侧边栏
    public static  final CodeMsg RIGHT_ROUTE_SUCCESS = new CodeMsg(914,"刷新动态侧边栏成功");
    public static  final CodeMsg RIGHT_ROUTE_ERROR = new CodeMsg(915,"刷新动态侧边栏失败");

    //团队申请模块
    public static final CodeMsg NO_EXIST_TEAM = new CodeMsg(3001,"团队不存在");
    public static final CodeMsg APPLY_TEAM_SUCCESS =  new CodeMsg(3002,"团队活动申请成功");
    public static final CodeMsg APPLY_TEAM_FAIL =  new CodeMsg(3003,"团队活动申请失败");
    public static final CodeMsg SHOW_ALLAPPLY_SUCCESS = new CodeMsg(3004,"展示团队活动成功");
    public static final CodeMsg SHOW_ALLAPPLY_ERROR = new CodeMsg(3005,"展示活动失败");
    public static final CodeMsg TEAM_REVIEWS_SUCCESS = new CodeMsg(3006,"团队活动审核成功");
    public static final CodeMsg TEAM_REVIEWS_ERROR = new CodeMsg(3007,"团队活动审核失败");
    public static final CodeMsg SUBMIT_APPROVAL_ERROR = new CodeMsg(3008,"团队申请书为空");
    public static final CodeMsg SUBMIT_FILE_ERROR =  new CodeMsg(3009, "团队申请书格式错误，请传pdf格式");


    //用户管理模块
    public static final CodeMsg LOGINVO_NULL = new CodeMsg(3101, "登录名或者密码为空");
    public static final CodeMsg USERNAME_NOTEXIST = new CodeMsg(3102, "用户名不存在或者密码错误");
    public static final CodeMsg LOGIN_SUCCESS = new CodeMsg(3103, "登录成功");
    public static final CodeMsg PASSWORD_ERROR = new CodeMsg(3104, "密码错误");
    public static final CodeMsg MODIFY_SUCCESS = new CodeMsg(3105, "修改个人信息成功");
    public static final CodeMsg MODIFY_ERROR = new CodeMsg(3106, "修改个人信息失败");
    public static final CodeMsg MODIFY_PASSWORD_SUCCESS = new CodeMsg(3107, "修改密码成功");
    public static final CodeMsg MODIFY_PASSWORD_ERROR = new CodeMsg(3108, "旧密码错误");
    public static final CodeMsg MESSAGE_SEND_SUCCESS = new CodeMsg(3109, "短信发送成功");
    public static final CodeMsg MESSAGE_SYSTEM_ERROR = new CodeMsg(3110, "短信系统错误");
    public static final CodeMsg MESSAGE_ERROR = new CodeMsg(3111, "验证码错误");
    public static final CodeMsg MESSAGE_LOST_USE = new CodeMsg(3112, "验证码失效");
    public static final CodeMsg MESSAGE_SENDED_ERROR = new CodeMsg(3113, "请60s后在重新尝试");
    public static final CodeMsg MESSAGE_NOT_SEND = new CodeMsg(3114, "验证码尚未发送");;

    //返回一个带参数的错误码
    public CodeMsg fillArgs(Object... args) {//变参
        int code = this.code;
        //message是填充了参数的message
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }
}