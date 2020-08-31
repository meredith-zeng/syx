package com.protecthair.service.Impl;


import com.protecthair.dao.TeamMemberMapper;
import com.protecthair.domain.TeamMember;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Result;
import com.protecthair.service.TeamMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class TeamMemberServiceImpl implements TeamMemberService {
    @Autowired
    TeamMemberMapper teamMemberMapper;
    public Result add(TeamMember member) {
        TeamMember teamMember=new TeamMember();
        BeanUtils.copyProperties(member,teamMember);
        if (1 == teamMemberMapper.insert(teamMember)) {
            return Result.CodeMsg(CodeMsg.ADD_TEAM_SUCCESS);
        } else {
            return Result.CodeMsg(CodeMsg.ADD_TEAM_FAILED);
        }
    }

    public Result modify(TeamMember member) {
        TeamMember teamMember=new TeamMember();
        BeanUtils.copyProperties(member,teamMember);
        if (1 == teamMemberMapper.updateByPrimaryKey(teamMember)) {
            return Result.CodeMsg(CodeMsg.EDIT_TEAM_SUCCESS);
        } else {
            return Result.CodeMsg(CodeMsg.EDIT_TEAM_FAILED);
        }
    }

    public Result remove(TeamMember member) {
        Integer teamMemberId= member.getTeamMemberId();
        if (1 == teamMemberMapper.deleteByPrimaryKey(teamMemberId)) {
            return Result.CodeMsg(CodeMsg.REMOVE_TEAM_SUCCESS);
        } else {
            return Result.CodeMsg(CodeMsg.REMOVE_TEAM_FAILED);
        }
    }

    public Result queryTeam(TeamMember member) {
        Integer teamMemberId= member.getTeamMemberId();
        ArrayList list =teamMemberMapper.selectByPrimaryKey(teamMemberId);
        if (list!=null) {
            return Result.success(list,CodeMsg.FIND_TEAM_SUCCESS);
        } else {
            return Result.error(CodeMsg.FIND_TEAM_FAILED);
        }
    }

    public Result findMember(TeamMember member) {
        String teamName= member.getTeamName();
        ArrayList list =teamMemberMapper.selectByName(teamName);
        if (list!=null) {
            return Result.success(list,CodeMsg.FIND_TEAM_SUCCESS);
        } else {
            return Result.error(CodeMsg.FIND_TEAM_FAILED);
        }
    }
}
