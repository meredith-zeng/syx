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


    //关联组织模块
    public static final CodeMsg ASSOCIATE_SUCCESS = new CodeMsg(207, "用户关联组织成功");
    public static final CodeMsg ASSOCIATE_EXIST = new CodeMsg(208, "该用户已经关联，请先解除关联");
    public static final CodeMsg ASSOCIATE_ERROR = new CodeMsg(210, "用户关联失败");

    //资产
    public static final CodeMsg APPLY_ASSETS_SUCCESS = new CodeMsg(300, "申报资产成功");
    public static final CodeMsg APPLY_ASSETS_ERROR = new CodeMsg(301, "资产申报错误");
    public static final CodeMsg APPLY_DEPARTMENT_NOEXIST = new CodeMsg(302, "属所组织不存在");
    public static final CodeMsg APPLY_PROPERTY_EXIST = new CodeMsg(303, "资产名称已存在");
    public static final CodeMsg QUERY_ASSETS_ERROR = new CodeMsg(304, "查询资产不存在");
    public static final CodeMsg QUERY_ASSETS_SUCCESS = new CodeMsg(305, "查询资产成功");
    //绩效
    public static final CodeMsg APPLY_PERF_SUCCESS=new CodeMsg(330,"绩效申报成功");
    public static final CodeMsg APPLY_PERF_ERROR=new CodeMsg(331,"失败,本月已经申报绩效");
    public static final CodeMsg CHECK_PERF_SUCCESS=new CodeMsg(332,"个人查询绩效成功");
    public static final CodeMsg CHECK_PERF_ERROR=new CodeMsg(333,"个人查询绩效成功");
    public static final CodeMsg SHOW_ALL_PERFORMANCE = new CodeMsg(334, "查看所有绩效申请成功");
    public static final CodeMsg REVIEW_PERFORMANCE_SUCCESS = new CodeMsg(335, "绩效审核成功");
    public static final CodeMsg REVIEW_PERFORMANCE_ERROR = new CodeMsg(336, "绩效审核失败");


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


    //组织管理
    public static CodeMsg ADD_ORG_SUCCESS = new CodeMsg(500,"增加组织成功");
    public static CodeMsg ADD_ORG_ERROR = new CodeMsg(501,"增加组织错误" );
    public static CodeMsg REMOVE_ORG_SUCCESS =new CodeMsg(502,"删除组织成功");
    public static CodeMsg REMOVE_ORG_ERROR =new CodeMsg(504,"删除组织失败");
    public static CodeMsg QUERY_ORG_SUCCESS = new CodeMsg(505,"查询组织成功");
    public static CodeMsg QUERY_ORG_ERROR = new CodeMsg(506,"查询组织错误" );
    public static CodeMsg EDIT_ORG_SUCCESS =new CodeMsg(507,"更新组织成功");
    public static CodeMsg EDIT_ORG_ERROR =new CodeMsg(508,"更新组织失败");
    public static CodeMsg ADD_ORG_EXIST_ERROR = new CodeMsg(509,"增加组织已存在" );

    //人事管理
    public static CodeMsg QUERY_HR_SUCCESS = new CodeMsg(600,"查询员工信息成功");
    public static CodeMsg QUERY_HR_ERROR = new CodeMsg(601,"查询员工信息错误" );
    public static CodeMsg EDIT_HR_SUCCESS =new CodeMsg(602,"更新员工信息成功");
    public static CodeMsg EDIT_HR_ERROR =new CodeMsg(604,"更新员工信息失败");
    public static CodeMsg APPLY_TITLE_SUCCESS=new CodeMsg(605,"职称申报成功");
    public static CodeMsg APPLY_TITLE_ERROR=new CodeMsg(606,"职称申报失败");
//    public static CodeMsg APPLY_PERF_SUCCESS=new CodeMsg(607,"绩效申报成功");
//    public static CodeMsg APPLY_PERF_ERROR=new CodeMsg(608,"绩效申报失败");
    public static CodeMsg VERIFY_TITLE_SUCCESS=new CodeMsg(609,"审批职称申报功");
    public static CodeMsg VERIFY_TITLE_ERROR=new CodeMsg(610,"审批职称申报失败");

    //供应商管理
    /**
     * 供应商信息管理：Supplier SUPPLIER
     *      * 登记供应商信息 NEW_SUPPLIER
     *      * 修改供应商信息 UPDATE_SUPPLIER
     *      * 查询供应商信息 SELECT_SUPPLIER
     *      * 查询所有供应商信息 QUERY_SUPPLIER
     *      * 删除指定供应商信息 DELETE_SUPPLIER
     * **/
    public static CodeMsg NEW_SUPPLIER_SUCCESS = new CodeMsg(700,"登记供应商信息成功");
    public static CodeMsg NEW_SUPPLIER_ERROR = new CodeMsg(701,"登记供应商信息失败");
    public static CodeMsg UPDATE_SUPPLIER_SUCCESS = new CodeMsg(702,"修改供应商信息成功");
    public static CodeMsg UPDATE_SUPPLIER_ERROR = new CodeMsg(703,"修改供应商信息失败");
    public static CodeMsg SELECT_SUPPLIER_SUCCESS = new CodeMsg(704,"查询供应商信息成功");
    public static CodeMsg SELECT_SUPPLIER_ERROR = new CodeMsg(705,"查询供应商信息失败");
    public static CodeMsg QUERY_SUPPLIER_SUCCESS = new CodeMsg(706,"查询所有供应商信息成功");
    public static CodeMsg QUERY_SUPPLIER_ERROR = new CodeMsg(707,"查询所有供应商信息失败");
    public static CodeMsg DELETE_SUPPLIER_SUCCESS = new CodeMsg(708,"删除指定供应商信息成功");
    public static CodeMsg DELETE_SUPPLIER_ERROR = new CodeMsg(709,"删除指定供应商信息失败");
    /**
     * 供应商评价管理：Supplier_evaluation  SUPPLIER_EVALUATION
     *      * 录入评价 NEW_SUPPLIER_EVALUATION
     *      * 删除评价 DELETE_SUPPLIER_EVALUATION
     *      * 修改评价 UPDATE_SUPPLIER_EVALUATION
     *      * 查询指定用户评价 SELECT_SUPPLIER_EVALUATION
     * **/
    public static CodeMsg NEW_SUPPLIER_EVALUATION_SUCCESS = new CodeMsg(800,"录入评价成功");
    public static CodeMsg NEW_SUPPLIER_EVALUATION_ERROR = new CodeMsg(801,"录入评价失败");
    public static CodeMsg DELETE_SUPPLIER_EVALUATION_SUCCESS = new CodeMsg(802,"删除评价成功");
    public static CodeMsg DELETE_SUPPLIER_EVALUATION_ERROR = new CodeMsg(803,"删除评价失败");
    public static CodeMsg UPDATE_SUPPLIER_EVALUATION_SUCCESS = new CodeMsg(804,"修改评价成功");
    public static CodeMsg UPDATE_SUPPLIER_EVALUATION_ERROR = new CodeMsg(805,"修改评价失败");
    public static CodeMsg SELECT_SUPPLIER_EVALUATION_SUCCESS = new CodeMsg(806,"查询指定用户指定评价成功");
    public static CodeMsg SELECT_SUPPLIER_EVALUATION_ERROR = new CodeMsg(807,"查询指定用户指定评价失败");
    public static CodeMsg QUERY_SUPPLIER_EVALUATION_SUCCESS = new CodeMsg(808,"查询指定用户所有评价成功");
    public static CodeMsg QUERY_SUPPLIER_EVALUATION_ERROR = new CodeMsg(809,"查询指定用户所有评价失败");
    //身份认证
    /***
     *     权限分配，即审核
     *     AUTHENTICATION_AUDIT
     *     申请进行部门用户身份认证
     *     AUTHENTICATION_APPLY_SECTOR
     *     申请进行供应商用户身份认证
     *     AUTHENTICATION_APPLY_SUPPLIER
     *     申请进行社会公众用户身份认证
     *     AUTHENTICATION_APPLY_CITIZEN
     *     查询指定用户的身份认证情况
     *     SELECT_CERTIFICATION
     *     查询所有用户的身份认证情况
     *      QUERY_CERTIFICATION
     * */
    public static CodeMsg AUTHENTICATION_AUDIT_SUCCESS = new CodeMsg(900,"审核成功");
    public static CodeMsg AUTHENTICATION_AUDIT_ERROR = new CodeMsg(901,"审核失败");
    public static CodeMsg AUTHENTICATION_APPLY_SECTOR_SUCCESS = new CodeMsg(902,"申请进行部门用户身份认证成功");
    public static CodeMsg AUTHENTICATION_APPLY_SECTOR_ERROR = new CodeMsg(903,"申请进行部门用户身份认证失败");
    public static CodeMsg AUTHENTICATION_APPLY_SUPPLIER_SUCCESS = new CodeMsg(904,"申请进行供应商用户身份认证成功");
    public static CodeMsg AUTHENTICATION_APPLY_SUPPLIER_ERROR = new CodeMsg(905,"申请进行供应商用户身份认证失败");
    public static CodeMsg AUTHENTICATION_APPLY_CITIZEN_SUCCESS = new CodeMsg(906,"申请进行社会公众用户身份认证成功");
    public static CodeMsg AUTHENTICATION_APPLY_CITIZEN_ERROR = new CodeMsg(907,"申请进行社会公众用户身份认证失败");
    public static CodeMsg SELECT_CERTIFICATION_SUCCESS = new CodeMsg(908,"查询指定用户的身份认证情况成功");
    public static CodeMsg SELECT_CERTIFICATION_ERROR = new CodeMsg(909,"查询指定用户的身份认证情况失败");
    public static CodeMsg QUERY_CERTIFICATION_SUCCESS = new CodeMsg(910,"查询所有用户的身份认证情况成功");
    public static CodeMsg QUERY_CERTIFICATION_ERROR = new CodeMsg(911,"查询所有用户的身份认证情况失败");
    public static CodeMsg AUTHENTICATION_APPLY_SUCCESS = new CodeMsg(912,"申请进行身份认证失败");
    public static CodeMsg AUTHENTICATION_APPLY_ERROR = new CodeMsg(913,"申请进行身份认证失败");
    public static   CodeMsg RIGHT_ROUTE_SUCCESS = new CodeMsg(914,"刷新动态侧边栏成功");
    public static   CodeMsg RIGHT_ROUTE_ERROR = new CodeMsg(915,"刷新动态侧边栏失败");
    //返回一个带参数的错误码
    public CodeMsg fillArgs(Object... args) {//变参
        int code = this.code;
        //message是填充了参数的message
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }
}
