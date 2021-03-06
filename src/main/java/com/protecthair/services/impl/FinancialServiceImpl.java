package com.protecthair.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.protecthair.dao.FinancialMapper;
import com.protecthair.dao.InvoiceMapper;
import com.protecthair.dao.TeamApplyMapper;
import com.protecthair.dao.TeamMapper;
import com.protecthair.domain.Expense;
import com.protecthair.domain.Invoice;
import com.protecthair.domain.Team;
import com.protecthair.domain.TeamApply;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Constant;
import com.protecthair.result.InvoiceResult;
import com.protecthair.result.Result;
import com.protecthair.services.FinancialService;
import com.protecthair.util.ClientUploadUtils;
import okhttp3.ResponseBody;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

//import com.protecthair.util.WageUitl;

/**
 * @author by liuquan
 * @Classname financialServiceImpl
 * @Description TODO
 * @Date 2020/8/10 13:50
 */
@Service
public class FinancialServiceImpl implements FinancialService {

    @Autowired
    FinancialMapper financialMapper;

    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    TeamApplyMapper mapper;



    /**
     * 保存报销申请
     *
     * @param picture
     * @param expense
     * @param req
     * @return
     */
    @Override
    public Result saveExpense(MultipartFile picture, Expense expense, String integer, HttpServletRequest req) throws Exception {
        // 判断文件是否为空
        Team team = mapper.selectTeamIDByStuId(integer);
        String expenseOrganization = team.getTeamName();
        if (picture.isEmpty()) {
            Result.error(CodeMsg.SUBMIT_APPROVAL_ERROR);
        }
        //picture.
        //获得物理路径webapp所在路径
        String pathRoot = req.getSession().getServletContext().getRealPath("");
        String path = "";
        if (!picture.isEmpty()) {
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = picture.getContentType();
            //获得文件后缀名称
            String imageName = contentType.substring(contentType.indexOf("/") + 1);
            path = "/file/" + uuid + "." + imageName;

            //voice Recognize
            ResponseBody responseBody = ClientUploadUtils.upload("http://192.168.110.132:11111/invoice-ocr", picture.getBytes(), imageName);
            String json = responseBody.string();
            ObjectMapper objectMapper = new ObjectMapper();
            InvoiceResult invoiceResult = objectMapper.readValue(json, InvoiceResult.class);
            Invoice invoice = invoiceResult.getData();
            System.out.println(invoice);
            //String teamName = expense.getExpenseOrganization();
            invoice.setTeamName(expenseOrganization);
            invoiceMapper.save(invoice);
            picture.transferTo(new File(pathRoot + path));
        }
        //图片路径
        expense.setExpensePic(path);
        expense.setExpenseCertifictedCondition("待审核");

        Expense expense1 = new Expense();
        BeanUtils.copyProperties(expense, expense1);
        expense1.setExpenseOrganization(expenseOrganization);
        //保存实体
        try {
            financialMapper.saveExpense(expense1);
            return Result.CodeMsg(CodeMsg.SUBMIT_APPROVAL_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.CodeMsg(CodeMsg.SUBMIT_NULL_ERROR);
        }

    }

    //查询所有报销

    @Override
    public List<Expense> selectAllExpenseList() {
        return financialMapper.selectAllExpenseList();
    }

    //根据组织名查询报销

    @Override
    public List<Expense> selectAllExpenseListByName(String name) {
        return financialMapper.selectAllExpenseListByName(name);
    }


    /**
     * ----------------------员工查询------------------------------
     */

    @Override
    public List<Expense> getExpenseApplyByIdAndStatus(String status, Integer memberid) {
        return financialMapper.getExpenseApplyByIdAndStatus(status, memberid);
    }

    @Override
    public List<Invoice> invoiceShow(String name,String stuId) {
//        Team team = mapper.selectTeamIDByStuId(stuId);
//        String teamName = team.getTeamName();
        return invoiceMapper.show(name);
    }

//    /**
//     * 工资计算
//     * @param id
//     * @return
//     */
//
//    public Result caculateSalary(Integer id) {
//        //年份,月份设置
//        Calendar calendar = Calendar.getInstance();
//        int month = calendar.get(Calendar.MONTH) + 1;
//        int years = calendar.get(Calendar.YEAR);
//        //基础工资
//        Double baseWage = WageUitl.baseWageComputer();
//        Performance performance = financialMapper.isPassPerformance(id, month, years);
//        List<Salary> salaryList;
//        //是否存在当月工资
//        boolean isExist = financialMapper.isExistCurMonthSalary(id,month,years).equals(1);
//        //本月绩效工资未申请或者申请未通过,都不加绩效
//        if(performance==null || performance.getPerformanceCondition().equals("申请未通过")){
//            //是否存在当月的工资
//            if (isExist){
//                //历史工资记录
//                salaryList =  financialMapper.selectAllWageById(id);
//            }else{
//                String isApplyPerformance= (performance==null)
//                        ?"未申请":"申请未通过";
//                //增加一条当月的记录在进行查询
//                Salary salary = new Salary(id,baseWage, 0D,baseWage+0D, month, years,isApplyPerformance);
//                financialMapper.addWage(salary);
//                salaryList =  financialMapper.selectAllWageById(id);
//            }
//            return Result.success(salaryList,CodeMsg.COMPUTER_SALARY_SUCCESS);
//        }else {
//            //本月绩效工资申请通过，加上本月的绩效
//            //是否存在当月的工资
//            if (isExist){
//                //历史工资记录
//                salaryList =  financialMapper.selectAllWageById(id);
//            }else{
//                //增加一条当月的记录在进行查询
//                Salary salary = new Salary(id,baseWage, performance.getWagePerformance()
//                        ,baseWage+performance.getWagePerformance(), month, years, "申请已通过");
//                financialMapper.addWage(salary);
//                salaryList =  financialMapper.selectAllWageById(id);
//            }
//            return Result.success(salaryList,CodeMsg.COMPUTER_SALARY_SUCCESS);
//        }
//    }
//

    @Override
    public List<Expense> getExpenseApplyById(Integer memberid) {
        return financialMapper.getExpenseApplyById(memberid);
    }

    //报销审核

    @Override
    public Result expenseReview(String expense_certifictedCondition, String id) {
        //更新报销状态
        if (Constant.DATE_CHANGE_SUCCESS.equals
                (financialMapper.updateExpenseReview(expense_certifictedCondition, id))) {
            return Result.success(null, CodeMsg.EXPENSE_REVIEW_SUCCESS);
        } else {
            return Result.error(CodeMsg.EXPENSE_REVIEW_ERROR);
        }
    }
}