package com.protecthair.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author by liuquan
 * @Classname Expense
 * @Description 审批报销实体类
 * @Date 2020/8/10 15:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    //审批单据业务编号
    //@NotBlank
    private Integer expenseCode;
    //组织的名称
    @NotBlank
    private String expenseOrganization;


    //报销金额

    private Double expenseMoney;

    //报销单据
    //@NotBlank
    private String expensePic;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expenseTime;

    //报销审核的信息
    //@NotBlank
    private String expenseCertifictedCondition;


}
