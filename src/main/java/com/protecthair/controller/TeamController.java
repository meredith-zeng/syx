package com.protecthair.controller;

import com.protecthair.domain.SessionUser;
import com.protecthair.domain.Team;
import com.protecthair.result.Result;
import com.protecthair.services.TeamService;
import com.protecthair.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/api")
public class TeamController {
    @Autowired
    TeamService teamService;

    //New Team
    @ResponseBody
    @RequestMapping(value = "/newTeam", method = RequestMethod.POST)
    public Result newTeam(Team team, HttpServletRequest request) {
        SessionUser sessionUser = SessionUtil.getSessionUserFromCookie(request);
        String name = sessionUser.getUser().getUserName();
        Integer stuId = Integer.valueOf(sessionUser.getUser().getUniversityCode());

        team.setTeamLeaderStudentId(stuId);
        team.setTeamLeaderStudentName(name);
        Result res=teamService.addTeam(team);
        return res;
    }
    //Modify Team
    @ResponseBody
    @RequestMapping(value = "/modifyTeam", method = RequestMethod.POST)
    public Result modifyTeam(Team team) {
        Result res=teamService.modifyTeam(team);
        return res;
    }
    //Remove Team
    @ResponseBody
    @RequestMapping(value = "/removeTeam", method = RequestMethod.POST)
    public Result removeTeam(Team team) {
        Result res=teamService.removeTeam(team);
        return res;
    }
    //Query Team
    @ResponseBody
    @RequestMapping(value = "/queryTeam", method = RequestMethod.POST)
    public Result queryTeam(Team team) {
        Result res=teamService.queryTeam(team);
        return res;
    }
    //Search Team
    @ResponseBody
    @RequestMapping(value = "/searchTeam", method = RequestMethod.POST)
    public Result searchTeam(Team team) {
        Result res=teamService.searchTeam(team);
        return res;
    }
//    //Show Team
//    @ResponseBody
//    @RequestMapping(value = "/showTeam", method = RequestMethod.POST)
//    public Result showTeam() {
//        Result res=teamService.showTeam();
//        return res;
//    }
}
