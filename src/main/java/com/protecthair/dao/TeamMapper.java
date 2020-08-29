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

    ArrayList<Team> search(String teamName);

}