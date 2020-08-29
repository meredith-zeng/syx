package com.protecthair.service;

import com.protecthair.domain.Team;
import com.protecthair.result.Result;

public interface TeamService {
    Result modifyTeam(Team team);

    Result addTeam(Team team);

    Result removeTeam(Team team);

    Result queryTeam(Team team);

    Result searchTeam(Team team);

    Result showTeam();
}
