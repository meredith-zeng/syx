package com.protecthair.domain;

public class TeamMember {
    private Integer teamMemberId;

    private Integer teamName;

    private String teamMemberName;

    private String studentId;

    private String teamMemberMajor;

    private String teamMemberCollege;

    private String isLeader;

    public TeamMember(Integer teamMemberId, Integer teamName, String teamMemberName, String studentId, String teamMemberMajor, String teamMemberCollege, String isLeader) {
        this.teamMemberId = teamMemberId;
        this.teamName = teamName;
        this.teamMemberName = teamMemberName;
        this.studentId = studentId;
        this.teamMemberMajor = teamMemberMajor;
        this.teamMemberCollege = teamMemberCollege;
        this.isLeader = isLeader;
    }

    public TeamMember() {
        super();
    }

    public Integer getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(Integer teamMemberId) {
        this.teamMemberId = teamMemberId;
    }

    public Integer getTeamName() {
        return teamName;
    }

    public void setTeamName(Integer teamName) {
        this.teamName = teamName;
    }

    public String getTeamMemberName() {
        return teamMemberName;
    }

    public void setTeamMemberName(String teamMemberName) {
        this.teamMemberName = teamMemberName == null ? null : teamMemberName.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getTeamMemberMajor() {
        return teamMemberMajor;
    }

    public void setTeamMemberMajor(String teamMemberMajor) {
        this.teamMemberMajor = teamMemberMajor == null ? null : teamMemberMajor.trim();
    }

    public String getTeamMemberCollege() {
        return teamMemberCollege;
    }

    public void setTeamMemberCollege(String teamMemberCollege) {
        this.teamMemberCollege = teamMemberCollege == null ? null : teamMemberCollege.trim();
    }

    public String getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader == null ? null : isLeader.trim();
    }
}