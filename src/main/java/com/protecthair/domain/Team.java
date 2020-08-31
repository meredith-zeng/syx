package com.protecthair.domain;

import java.util.Date;

public class Team {
    //团队id*
    private Integer teamId;
    //团队名
    private String teamName;
    //团队学院
    private String teamCollege;
    //队长姓名
    private String teamLeaderStudentName;
    //队长id
    private Integer teamLeaderStudentId;
    //团队等级
    private String teamLevel;
    //创建时间*
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