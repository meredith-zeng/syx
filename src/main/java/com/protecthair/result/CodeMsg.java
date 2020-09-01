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
    //返回一个带参数的错误码
    public CodeMsg fillArgs(Object... args) {//变参
        int code = this.code;
        //message是填充了参数的message
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }
}
