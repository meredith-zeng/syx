package com.protecthair.dao;

import com.protecthair.domain.TeamMember;

public interface TeamMemberMapper {
    int deleteByPrimaryKey(Integer teamMemberId);

    int insert(TeamMember record);

    int insertSelective(TeamMember record);

    TeamMember selectByPrimaryKey(Integer teamMemberId);

    int updateByPrimaryKeySelective(TeamMember record);

    int updateByPrimaryKey(TeamMember record);
}