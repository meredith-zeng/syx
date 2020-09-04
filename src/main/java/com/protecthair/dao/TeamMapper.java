package com.protecthair.dao;

import com.protecthair.domain.Team;

import java.util.ArrayList;

public interface TeamMapper {
    int deleteByPrimaryKey(Integer teamId);

    int insert(Team record);

    int insertSelective(Team record);

    ArrayList<Team> selectByPrimaryKey(Integer teamId);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);

    //自己写的sql
    Team selectTeamIDByStuId(String stuId);
//以下代码有可能为刘权和叶俊麟的冲突代码，需要他们自己看一下
    ArrayList<Team> search(String teamName);


    Team check(String teamName);
}