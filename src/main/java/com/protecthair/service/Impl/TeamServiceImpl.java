package com.protecthair.service.Impl;
import com.protecthair.dao.TeamMapper;
import com.protecthair.domain.Team;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Result;
import com.protecthair.service.TeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
public class TeamServiceImpl implements TeamService{
    @Autowired
    TeamMapper teamMapper;


    public Result modifyTeam(Team team) {
        Team team1=new Team();
        BeanUtils.copyProperties(team,team1);
        if (1 == teamMapper.updateByPrimaryKey(team1)) {
            return Result.CodeMsg(CodeMsg.EDIT_TEAM_SUCCESS);
        } else {
            return Result.CodeMsg(CodeMsg.EDIT_TEAM_FAILED);
        }
    }

    public Result addTeam(Team team) {
        Team team1=new Team();
        BeanUtils.copyProperties(team,team1);
        if (1 == teamMapper.insert(team1)) {
            return Result.CodeMsg(CodeMsg.ADD_TEAM_SUCCESS);
        } else {
            return Result.CodeMsg(CodeMsg.ADD_TEAM_FAILED);
        }
    }

    public Result removeTeam(Team team) {
        Integer teamId=team.getTeamId();
        if (1 == teamMapper.deleteByPrimaryKey(teamId)) {
            return Result.CodeMsg(CodeMsg.REMOVE_TEAM_SUCCESS);
        } else {
            return Result.CodeMsg(CodeMsg.REMOVE_TEAM_FAILED);
        }
    }

    public Result queryTeam(Team team) {
        Integer teamId=team.getTeamId();
        ArrayList list =teamMapper.selectByPrimaryKey(teamId);
        if (list!=null ) {
            return Result.success(list,CodeMsg.FIND_TEAM_SUCCESS);
        } else {
            return Result.error(CodeMsg.FIND_TEAM_FAILED);
        }
    }

    public Result searchTeam(Team team) {
        String teamName=team.getTeamName();
        ArrayList list =teamMapper.search(teamName);
        if (list!=null ) {
            return Result.success(list,CodeMsg.FIND_TEAM_SUCCESS);
        } else {
            return Result.error(CodeMsg.FIND_TEAM_FAILED);
        }
    }

    public Result showTeam() {
        return null;
    }
}
