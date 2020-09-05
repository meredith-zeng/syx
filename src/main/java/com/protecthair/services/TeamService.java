package com.protecthair.services;

import com.protecthair.domain.Team;
import com.protecthair.result.Result;

public interface TeamService {
    Result modifyTeam(Team team);

    Result addTeam(Team team);

    Result removeTeam(Team team);

    Result queryTeam(Team team);

    Result searchTeam(String team);

    Result showTeam();
}