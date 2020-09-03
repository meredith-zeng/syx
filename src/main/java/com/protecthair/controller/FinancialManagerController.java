package com.protecthair.controller;

import com.protecthair.domain.Expense;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Result;
import com.protecthair.services.FinancialService;

//import com.protecthair.vo.QueryExpenseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author by liuquan
 * @Classname financialManagerController
 * @Description 财务管理的控制器
 * @Date 2020/8/10 13:13
 */
@Controller
@RequestMapping(value = "/api")
public class FinancialManagerController {

    @Autowired
    FinancialService financialService;

    /**------------------------------------------用户模块begin------------------------------**/
    /**
     * 在线报销申请
     * @param picture 报销的单据
     * @param expense 报销的实体类
     * @param req     请求
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/expenseApply", method = RequestMethod.POST)
    public Result submitApproval(@RequestParam("expensePicter") MultipartFile picture,Expense expense,
                                 HttpServletRequest req, BindingResult result) throws IOException {
        if (result.hasErrors()){
            return Result.CodeMsg(CodeMsg.SUBMIT_NULL_ERROR);
        }
       return financialService.saveExpense(picture,expense,req);
    }

    /**
     * 根据状态查看
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/expenseApplyListByIdStatus", method = RequestMethod.POST)
    public Result getExpenseApplyByIdAndStatus(@RequestParam("expenseStatus")String status,HttpServletRequest request){

        //工号
        //Integer memberid = sessionUser.getOrgMember().getId();
        Integer memberid = -1;
        return Result.success(financialService.getExpenseApplyByIdAndStatus(status,memberid)
                ,CodeMsg.QUERY_EXPENSE_SUCCESS);
    }

    /**
     * 根据员工工号查看报销申请列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/expenseApplyListById", method = RequestMethod.POST)
    public Result getExpenseApplyById(HttpServletRequest request){

        //Integer memberid = sessionUser.getOrgMember().getId();
        Integer memberid = -1;
        List<Expense> expenseList= financialService.getExpenseApplyById(memberid);
        Result res =   Result.success(expenseList,CodeMsg.QUERY_EXPENSE_SUCCESS);
        return res;
    }

//    /**
//     * 总工资计算（绩效+基本工资）
//     * @param request
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/caculateTotalSalary", method = RequestMethod.POST)
//    public Result caculateSalary(HttpServletRequest request){
//        SessionUser user = SessionUtil.getSessionUserFromCookie(request);
//        //获取工号
//        //Integer orgMemberId = user.getOrgMember().getId();
//        Integer orgMemberId = -1;
//        return financialService.caculateSalary(orgMemberId);
//    }


    /**------------------------------------------用户模块end------------------------------**/



    /**------------------------------------------管理员模块begin------------------------------**/

    /**
     * 根据报销组织名称查询，模糊查询
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/expenseQueryName",method = RequestMethod.POST)
    public Result getAllExpenseApplyByOrgName(String expenseName){
        List<Expense> expenseList = financialService.selectAllExpenseListByName(expenseName);
        return Result.success(expenseList,CodeMsg.QUERY_EXPENSE_SUCCESS);
    }

    /**
     * 管理员查看所有报销申请列表
     * @return    
     */
    @ResponseBody
    @RequestMapping(value = "/getAllExpenseApply",method = RequestMethod.POST)
    public Result getAllExpenseApply(){
        List<Expense> expenseList = financialService.selectAllExpenseList();
        return Result.success(expenseList,CodeMsg.QUERY_EXPENSE_SUCCESS);
    }

    /**
     * 管理员进行报销审核
     * @param id     报销的业务id，即主键
     * @param certificationCertificatedCondition   报销状态（通过，未通过）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/expenseReview", method = RequestMethod.POST)
    public Result expenseReview(@RequestParam(value = "expenseCode") String id,
                                String certificationCertificatedCondition) {
     Result result =    financialService.expenseReview(certificationCertificatedCondition,id);
       return result;
    }


    /**------------------------------------------管理员模块end------------------------------**/

}
