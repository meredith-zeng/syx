package com.protecthair.domain;

import java.util.Date;

public class Log {
    private Integer logCode;

    private Integer logTeamId;

    private Date logOperateTime;

    private Date logTime;

    private String logSpecific;

    public Log(Integer logCode, Integer logTeamId, Date logOperateTime, Date logTime) {
        this.logCode = logCode;
        this.logTeamId = logTeamId;
        this.logOperateTime = logOperateTime;
        this.logTime = logTime;
    }

    public Log(Integer logCode, Integer logTeamId, Date logOperateTime, Date logTime, String logSpecific) {
        this.logCode = logCode;
        this.logTeamId = logTeamId;
        this.logOperateTime = logOperateTime;
        this.logTime = logTime;
        this.logSpecific = logSpecific;
    }

    public Log() {
        super();
    }

    public Integer getLogCode() {
        return logCode;
    }

    public void setLogCode(Integer logCode) {
        this.logCode = logCode;
    }

    public Integer getLogTeamId() {
        return logTeamId;
    }

    public void setLogTeamId(Integer logTeamId) {
        this.logTeamId = logTeamId;
    }

    public Date getLogOperateTime() {
        return logOperateTime;
    }

    public void setLogOperateTime(Date logOperateTime) {
        this.logOperateTime = logOperateTime;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogSpecific() {
        return logSpecific;
    }

    public void setLogSpecific(String logSpecific) {
        this.logSpecific = logSpecific == null ? null : logSpecific.trim();
    }
}