package com.protecthair.dao;

import com.protecthair.domain.Expense;
//import com.protecthair.domain.Performance;
//import com.protecthair.domain.Salary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author by liuquan
 * @Classname FinancialMapper
 * @Description TODO
 * @Date 2020/8/10 14:23
 */
public interface FinancialMapper {

    String TABLE_NAME = " expense ";

    String INSERT_FIELDS = " member_id, expense_organization, expense_money," +
            "expense_event,expense_agent,expense_pic,expense_certifictedCondition ";
    String SELECT_FIELDS = " expense_code , " + INSERT_FIELDS + ", expense_time";

    //绩效
    String TABLE_WAGE_NAME = " wage ";
    String INSERT_FIELDS_WAGE ="wage_memberid, wage_basic,wage_performance, wage_whole, " +
            "wage_month,wage_years,apply_performance";
    String SELECT_FIELDS_WAGE = " wage_code , " + INSERT_FIELDS;
//    //插入
//    @Insert({"insert into wage (", INSERT_FIELDS_WAGE,
//            ") values (#{wageMemberid},#{wageBasic},#{wagePerformance}," +
//                    "#{wageWhole},#{wageMonth},#{wageYears},#{applyPerformance})"})
//    Salary addWage(Salary salary);
//
//
//    @Select({"select count(*) from ", TABLE_WAGE_NAME ,"where wage_month = #{month} and " +
//            " wage_years = #{years} and wage_memberid=#{id} "})
//    Integer isExistCurMonthSalary(@Param("id") Integer id, @Param("month") Integer month,
//                                  @Param("years") Integer years);
//
//
//    @Select({"select * from ", TABLE_WAGE_NAME ," where wage_memberid=#{id}"})
//    List<Salary>  selectAllWageById(Integer id);








    //插入审批
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values ( #{memberId}, #{expenseOrganization},#{expenseMoney},#{expenseEvent}," +
                    "#{expenseAgent},#{expensePic},#{expenseCertifictedCondition})"})
    Integer saveExpense(Expense expense);

    //管理员获取所有审批
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME," where expense_certifictedCondition ='待审核' "})
    List<Expense> selectAllExpenseList();

    //管理员根据组织
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where expense_certifictedCondition ='待审核' and expense_organization like CONCAT('%',#{name},'%') "})
    List<Expense> selectAllExpenseListByName(String name);

    //管理员根据状态
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where expense_certifictedCondition =#{status} "})
    List<Expense> selectAllExpenseListByStatus(String status);


    //更新审批状态
    @Update({"update ",TABLE_NAME ,"set expense_certifictedCondition=" +
            "#{expenseCertifictedCondition} where expense_code=#{id}"})
    Integer updateExpenseReview(@Param("expenseCertifictedCondition") String expenseCertifictedCondition,
                                @Param("id") String id);

    //个人获取所有申请
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME,"where member_id = #{memberid}"})
    List<Expense> getExpenseApplyById(Integer memberid);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME,"where expense_certifictedCondition = #{status} and " +
            " member_id = #{id}"})
    List<Expense> getExpenseApplyByIdAndStatus(@Param("status") String status, @Param("id") Integer id);




//    @Select({"select  wage_performance, performance_condition  from performance where " +
//            "performance_years = #{years} and performance_month = #{month} " +
//            "and organization_member = #{id}"})
//    Performance isPassPerformance(@Param("id") Integer id, @Param("month") int month,
//                                  @Param("years") int years);


}
