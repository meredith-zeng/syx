
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

    //通用
    public static CodeMsg SERVER_ERROR = new CodeMsg(101, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(102, "参数校验异常");
    public static CodeMsg NULL_DATA = new CodeMsg(103, "请填写完整信息");;

    //注册模块
    public static final CodeMsg REGISTER_SUCCESS = new CodeMsg(200, "注册成功");
    public static final CodeMsg REGISTER_EXIST_PHONENUMBER = new CodeMsg(201, "手机号码已经被注册");
    public static final CodeMsg REGISTER_ERROR_BIRTH = new CodeMsg(202, "错误的出生年月");

    //登录模块
    public static final CodeMsg LOGINVO_NULL = new CodeMsg(210, "登录名或者密码为空");
    public static final CodeMsg USERNAME_NOTEXIST = new CodeMsg(211, "用户名不存在或者密码错误");
    public static final CodeMsg LOGIN_SUCCESS = new CodeMsg(212, "登录成功");
    public static final CodeMsg PASSWORD_ERROR = new CodeMsg(213, "密码错误");

    //修改模块
    public static final CodeMsg MODIFY_SUCCESS = new CodeMsg(220, "修改成功");
    public static final CodeMsg MODIFY_ERROR = new CodeMsg(221, "修改个人信息失败");
    public static final CodeMsg MODIFY_PASSWORD_SUCCESS = new CodeMsg(222, "修改密码成功");
    public static final CodeMsg MODIFY_PASSWORD_ERROR = new CodeMsg(223, "旧密码错误");

    //短信验证
    public static  CodeMsg MESSAGE_SEND_SUCCESS = new CodeMsg(230, "短信发送成功");
    public static  CodeMsg MESSAGE_SYSTEM_ERROR = new CodeMsg(231, "短信系统错误");
    public static  CodeMsg MESSAGE_PHONENUMBER_ERROR = new CodeMsg(232, "手机号码错误");
    public static  CodeMsg MESSAGE_ERROR = new CodeMsg(231, "验证码错误");


    //Team Manage
    public static final CodeMsg ADD_TEAM_SUCCESS=new CodeMsg(300,"Add Team Success");
    public static final CodeMsg ADD_TEAM_FAILED=new CodeMsg(301,"Add Team Failed");
    public static final CodeMsg EDIT_TEAM_SUCCESS=new CodeMsg(302,"Edit Team Success");
    public static final CodeMsg EDIT_TEAM_FAILED=new CodeMsg(303,"Edit Team Failed");
    public static final CodeMsg FIND_TEAM_SUCCESS=new CodeMsg(304,"Find Team Success");
    public static final CodeMsg FIND_TEAM_FAILED=new CodeMsg(305,"Find Team Failed");
    public static final CodeMsg REMOVE_TEAM_SUCCESS=new CodeMsg(306,"Remove Team Success");
    public static final CodeMsg REMOVE_TEAM_FAILED=new CodeMsg(307,"Remove Team Failed");

    //财务管理
    public static final CodeMsg SUBMIT_APPROVAL_SUCCESS = new CodeMsg(400, "报销申请成功");
    public static final CodeMsg SUBMIT_APPROVAL_ERROR = new CodeMsg(401, "报销申请失败");
    public static final CodeMsg SUBMIT_NULL_ERROR = new CodeMsg(402, "上传单据为空");
    public static final CodeMsg QUERY_EXPENSE_SUCCESS = new CodeMsg(403, "查询报销成功");
    public static final CodeMsg EXPENSE_REVIEW_SUCCESS = new CodeMsg(404, "报销审核成功");
    public static final CodeMsg EXPENSE_REVIEW_ERROR = new CodeMsg(405, "报销审核未通过");
    public static final CodeMsg COMPUTER_SALARY_SUCCESS = new CodeMsg(406, "工资计算成功");
    public static final CodeMsg COMPUTER_SALARY_ERROR = new CodeMsg(407, "工资计算出错");
    public static final CodeMsg NULL_MEMBERID = new CodeMsg(101, "工号不存在");
    //返回一个带参数的错误码
    public CodeMsg fillArgs(Object... args) {//变参
        int code = this.code;
        //message是填充了参数的message
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }
}