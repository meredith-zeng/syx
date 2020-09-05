package com.protecthair.controller;

import com.protecthair.domain.TeamMember;
import com.protecthair.result.Result;
import com.protecthair.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api")
public class TeamMemberController {


    @Autowired
    TeamMemberService teamMemberService;

    //New Team
    @ResponseBody
    @RequestMapping(value = "/newTeamMember", method = RequestMethod.POST)
    public Result add(TeamMember member) {
        Result res = teamMemberService.add(member);
        return res;
    }

    //Modify Team
    @ResponseBody
    @RequestMapping(value = "/modifyTeamMemeber", method = RequestMethod.POST)
    public Result modify(TeamMember member) {
        Result res = teamMemberService.modify(member);
        return res;
    }

    //Remove Team
    @ResponseBody
    @RequestMapping(value = "/removeTeamMember", method = RequestMethod.POST)
    public Result remove(TeamMember member) {
        Result res = teamMemberService.remove(member);
        return res;
    }

    //Query Team
    @ResponseBody
    @RequestMapping(value = "/queryTeamMember", method = RequestMethod.POST)
    public Result query(TeamMember member) {
        Result res = teamMemberService.queryTeam(member);
        return res;
    }

    //Search Team
    @ResponseBody
    @RequestMapping(value = "/findTeamMember", method = RequestMethod.POST)
    public Result find(TeamMember member) {
        Result res = teamMemberService.findMember(member);
        return res;
    }

//        //Show Team
//        @ResponseBody
//        @RequestMapping(value = "/showTeamMember", method = RequestMethod.POST)
//        public Result showTeam() {
//            Result res = teamService.showTeam();
//            return res;
//        }

}
