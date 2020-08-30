package com.protecthair.domain;

import java.util.Date;

public class Expense {
    private Integer expenseCode;

    private Integer organizationCode;

    private Date expenseTime;

    private String expenseOrganization;

    private Float expenseMoney;

    private String expenseEvent;

    private String expenseAgent;

    private String expensePic;

    private String expenseCertifictedcondition;

    public Expense(Integer expenseCode, Integer organizationCode, Date expenseTime, String expenseOrganization, Float expenseMoney, String expenseEvent, String expenseAgent, String expensePic, String expenseCertifictedcondition) {
        this.expenseCode = expenseCode;
        this.organizationCode = organizationCode;
        this.expenseTime = expenseTime;
        this.expenseOrganization = expenseOrganization;
        this.expenseMoney = expenseMoney;
        this.expenseEvent = expenseEvent;
        this.expenseAgent = expenseAgent;
        this.expensePic = expensePic;
        this.expenseCertifictedcondition = expenseCertifictedcondition;
    }

    public Expense() {
        super();
    }

    public Integer getExpenseCode() {
        return expenseCode;
    }

    public void setExpenseCode(Integer expenseCode) {
        this.expenseCode = expenseCode;
    }

    public Integer getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(Integer organizationCode) {
        this.organizationCode = organizationCode;
    }

    public Date getExpenseTime() {
        return expenseTime;
    }

    public void setExpenseTime(Date expenseTime) {
        this.expenseTime = expenseTime;
    }

    public String getExpenseOrganization() {
        return expenseOrganization;
    }

    public void setExpenseOrganization(String expenseOrganization) {
        this.expenseOrganization = expenseOrganization == null ? null : expenseOrganization.trim();
    }

    public Float getExpenseMoney() {
        return expenseMoney;
    }

    public void setExpenseMoney(Float expenseMoney) {
        this.expenseMoney = expenseMoney;
    }

    public String getExpenseEvent() {
        return expenseEvent;
    }

    public void setExpenseEvent(String expenseEvent) {
        this.expenseEvent = expenseEvent == null ? null : expenseEvent.trim();
    }

    public String getExpenseAgent() {
        return expenseAgent;
    }

    public void setExpenseAgent(String expenseAgent) {
        this.expenseAgent = expenseAgent == null ? null : expenseAgent.trim();
    }

    public String getExpensePic() {
        return expensePic;
    }

    public void setExpensePic(String expensePic) {
        this.expensePic = expensePic == null ? null : expensePic.trim();
    }

    public String getExpenseCertifictedcondition() {
        return expenseCertifictedcondition;
    }

    public void setExpenseCertifictedcondition(String expenseCertifictedcondition) {
        this.expenseCertifictedcondition = expenseCertifictedcondition == null ? null : expenseCertifictedcondition.trim();
    }
}