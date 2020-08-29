package com.protecthair.dao;

import com.protecthair.domain.Expense;

public interface ExpenseMapper {
    int deleteByPrimaryKey(Integer expenseCode);

    int insert(Expense record);

    int insertSelective(Expense record);

    Expense selectByPrimaryKey(Integer expenseCode);

    int updateByPrimaryKeySelective(Expense record);

    int updateByPrimaryKey(Expense record);
}