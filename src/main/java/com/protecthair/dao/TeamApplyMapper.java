package com.protecthair.dao;

import com.protecthair.domain.Team;
import com.protecthair.domain.TeamApply;

import java.util.List;

public interface TeamApplyMapper {
    int deleteByPrimaryKey(Integer teamId);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Integer teamId);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);

    //自己写的sql
    Team selectTeamIDByStuId(String stuId);

    Integer addTeamApply(TeamApply teamApply);

    List<TeamApply> showApplyByStatus(String status);

    List<TeamApply> showMyApply(String stuId);

    Integer reviewTeam(TeamApply teamApply);
}