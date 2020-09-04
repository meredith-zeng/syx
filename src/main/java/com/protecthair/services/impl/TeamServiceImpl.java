package com.protecthair.services.impl;
import com.protecthair.dao.TeamMapper;
import com.protecthair.domain.Team;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Result;
import com.protecthair.services.TeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TeamServiceImpl implements TeamService{
    @Autowired
    TeamMapper teamMapper;


    @Override
    public Result modifyTeam(Team team) {
        Team team1=new Team();
        BeanUtils.copyProperties(team,team1);
        if (1 == teamMapper.updateByPrimaryKey(team1)) {
            return Result.CodeMsg(CodeMsg.EDIT_TEAM_SUCCESS);
        } else {
            return Result.CodeMsg(CodeMsg.EDIT_TEAM_FAILED);
        }
    }

    @Override
    public Result addTeam(Team team) {
        Team team1=new Team();
        BeanUtils.copyProperties(team,team1);
        String name=team1.getTeamName();
        if (teamMapper.check(name)==null) {
            try {
                if (1 == teamMapper.insert(team1)) {
                    return Result.CodeMsg(CodeMsg.ADD_TEAM_SUCCESS);
                } else {
                    return Result.CodeMsg(CodeMsg.ADD_TEAM_FAILED1);
                }
            }catch (Exception e){
                return Result.CodeMsg(CodeMsg.ADD_TEAM_FAILED1);
            }

        }else {
            return Result.CodeMsg(CodeMsg.ADD_TEAM_FAILED);
        }
    }

    @Override
    public Result removeTeam(Team team) {
        Integer teamId=team.getTeamId();
        if (1 == teamMapper.deleteByPrimaryKey(teamId)) {
            return Result.CodeMsg(CodeMsg.REMOVE_TEAM_SUCCESS);
        } else {
            return Result.CodeMsg(CodeMsg.REMOVE_TEAM_FAILED);
        }
    }

    @Override
    public Result queryTeam(Team team) {
        Integer teamId=team.getTeamId();
        ArrayList list =teamMapper.selectByPrimaryKey(teamId);
        if (list!=null ) {
            return Result.success(list,CodeMsg.FIND_TEAM_SUCCESS);
        } else {
            return Result.error(CodeMsg.FIND_TEAM_FAILED);
        }
    }

    @Override
    public Result searchTeam(Team team) {
        String teamName=team.getTeamName();
        ArrayList list =teamMapper.search(teamName);
        if (list!=null ) {
            return Result.success(list,CodeMsg.FIND_TEAM_SUCCESS);
        } else {
            return Result.error(CodeMsg.FIND_TEAM_FAILED);
        }
    }

    @Override
    public Result showTeam() {
        return null;
    }
}
