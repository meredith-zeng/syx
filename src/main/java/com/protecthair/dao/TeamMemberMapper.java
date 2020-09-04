package com.protecthair.dao;

import com.protecthair.domain.TeamMember;

import java.util.ArrayList;

public interface TeamMemberMapper {
    int deleteByPrimaryKey(Integer teamMemberId);

    int insert(TeamMember record);

    int insertSelective(TeamMember record);

    ArrayList<TeamMember> selectByPrimaryKey(Integer teamMemberId);

    int updateByPrimaryKeySelective(TeamMember record);

    int updateByPrimaryKey(TeamMember record);

    ArrayList<TeamMember> find(String name);

    TeamMember check(String sid);
}