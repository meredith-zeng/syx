package com.protecthair.domain;

import java.util.Date;

public class Log {
    private Integer logCode;

    private Integer logTeamId;

    private Date supplierEvaluateTime;

    private String logSpecific;

    public Log(Integer logCode, Integer logTeamId, Date supplierEvaluateTime) {
        this.logCode = logCode;
        this.logTeamId = logTeamId;
        this.supplierEvaluateTime = supplierEvaluateTime;
    }

    public Log(Integer logCode, Integer logTeamId, Date supplierEvaluateTime, String logSpecific) {
        this.logCode = logCode;
        this.logTeamId = logTeamId;
        this.supplierEvaluateTime = supplierEvaluateTime;
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

    public Date getSupplierEvaluateTime() {
        return supplierEvaluateTime;
    }

    public void setSupplierEvaluateTime(Date supplierEvaluateTime) {
        this.supplierEvaluateTime = supplierEvaluateTime;
    }

    public String getLogSpecific() {
        return logSpecific;
    }

    public void setLogSpecific(String logSpecific) {
        this.logSpecific = logSpecific == null ? null : logSpecific.trim();
    }
}