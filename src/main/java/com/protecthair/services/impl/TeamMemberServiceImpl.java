package com.protecthair.services.impl;


import com.protecthair.dao.TeamApplyMapper;
import com.protecthair.dao.TeamMemberMapper;
import com.protecthair.domain.Team;
import com.protecthair.domain.TeamMember;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Result;
import com.protecthair.services.TeamMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {
    @Autowired
    TeamMemberMapper teamMemberMapper;
    @Autowired
    TeamApplyMapper teamApplyMapper;

    @Override
    public Result add(TeamMember member, String stuId) {
        Team team = teamApplyMapper.selectTeamIDByStuId(stuId);
        String teamName = team.getTeamName();
        TeamMember teamMember = new TeamMember();
        BeanUtils.copyProperties(member, teamMember);
        String sid = teamMember.getStudentId();
        if (teamMemberMapper.check(sid) == null) {
            teamMember.setTeamName(teamName);
            if (1 == teamMemberMapper.insert(teamMember)) {
                return Result.CodeMsg(CodeMsg.ADD_TEAM_SUCCESS);
            } else {
                return Result.CodeMsg(CodeMsg.ADD_TEAM_FAILED);
            }
        } else {
            return Result.CodeMsg(CodeMsg.ADD_TEAM_FAILED);
        }

    }

    @Override
    public Result modify(TeamMember member) {
        TeamMember teamMember = new TeamMember();
        BeanUtils.copyProperties(member, teamMember);
        if (1 == teamMemberMapper.updateByPrimaryKey(teamMember)) {
            return Result.CodeMsg(CodeMsg.EDIT_TEAM_SUCCESS);
        } else {
            return Result.CodeMsg(CodeMsg.EDIT_TEAM_FAILED);
        }
    }

    @Override
    public Result remove(TeamMember member) {
        Integer teamMemberId = member.getTeamMemberId();
        if (1 == teamMemberMapper.deleteByPrimaryKey(teamMemberId)) {
            return Result.CodeMsg(CodeMsg.REMOVE_TEAM_SUCCESS);
        } else {
            return Result.CodeMsg(CodeMsg.REMOVE_TEAM_FAILED);
        }
    }

    @Override
    public Result queryTeam(TeamMember member) {
        Integer teamMemberId = member.getTeamMemberId();
        ArrayList list = teamMemberMapper.selectByPrimaryKey(teamMemberId);
        if (list != null) {
            return Result.success(list, CodeMsg.FIND_TEAM_SUCCESS);
        } else {
            return Result.error(CodeMsg.FIND_TEAM_FAILED);
        }
    }

    @Override
    public Result findMember(TeamMember member) {
        String name = member.getTeamName();
        ArrayList list = teamMemberMapper.find(name);
        if (list != null) {
            return Result.success(list, CodeMsg.FIND_TEAM_SUCCESS);
        } else {
            return Result.error(CodeMsg.FIND_TEAM_FAILED);
        }
    }
}
