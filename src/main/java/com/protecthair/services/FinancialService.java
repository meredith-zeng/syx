package com.protecthair.services;

import com.protecthair.domain.Expense;
//import com.protecthair.domain.Salary;
import com.protecthair.result.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author by liuquan
 * @Classname financialService
 * @Description TODO
 * @Date 2020/8/10 13:15
 */
public interface FinancialService {

    /**
     * 保存报销申请
     * @param expense
     * @return
     */
    Result saveExpense(MultipartFile picture
            , Expense expense, HttpServletRequest req) throws Exception;

    Result expenseReview(String expense_certifictedCondition, String id);

    //管理员根据组织名称来查询
    List<Expense> selectAllExpenseListByName(String name);
    //管理员获取所有的报销查询
    List<Expense> selectAllExpenseList();


    //员工根据工号查询自己所有报销
    List<Expense> getExpenseApplyById(Integer memberid);
    //圆滚滚通过
    List<Expense>  getExpenseApplyByIdAndStatus(String status, Integer memberid);


//    Result caculateSalary(Integer id);
}
