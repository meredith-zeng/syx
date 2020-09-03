package com.protecthair.services;

import com.protecthair.domain.TeamMember;
import com.protecthair.result.Result;

public interface TeamMemberService {
    Result add(TeamMember member);

    Result modify(TeamMember member);

    Result remove(TeamMember member);

    Result queryTeam(TeamMember member);

    Result findMember(TeamMember member);
}