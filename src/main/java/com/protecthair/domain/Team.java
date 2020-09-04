package com.protecthair.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class Team {
    private Integer teamId;

    private String teamName;

    private String teamCollege;

    private String teamLeaderStudentName;

    private Integer teamLeaderStudentId;

    private String teamLevel;

    private Date createdTime;

    public Team(Integer teamId, String teamName, String teamCollege, String teamLeaderStudentName, Integer teamLeaderStudentId, String teamLevel, Date createdTime) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamCollege = teamCollege;
        this.teamLeaderStudentName = teamLeaderStudentName;
        this.teamLeaderStudentId = teamLeaderStudentId;
        this.teamLevel = teamLevel;
        this.createdTime = createdTime;
    }

    public Team() {
        super();
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public String getTeamCollege() {
        return teamCollege;
    }

    public void setTeamCollege(String teamCollege) {
        this.teamCollege = teamCollege == null ? null : teamCollege.trim();
    }

    public String getTeamLeaderStudentName() {
        return teamLeaderStudentName;
    }

    public void setTeamLeaderStudentName(String teamLeaderStudentName) {
        this.teamLeaderStudentName = teamLeaderStudentName == null ? null : teamLeaderStudentName.trim();
    }

    public Integer getTeamLeaderStudentId() {
        return teamLeaderStudentId;
    }

    public void setTeamLeaderStudentId(Integer teamLeaderStudentId) {
        this.teamLeaderStudentId = teamLeaderStudentId;
    }

    public String getTeamLevel() {
        return teamLevel;
    }

    public void setTeamLevel(String teamLevel) {
        this.teamLevel = teamLevel == null ? null : teamLevel.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}