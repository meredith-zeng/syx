package com.protecthair.domain;

import java.util.Date;

public class Certification {
    private Integer certificationCode;

    private Integer userId;

    private Integer certificationTypeCode;

    private String certificationCertificatedcondition;

    private String certificationAddress;

    private Date createdTime;

    public Certification(Integer certificationCode, Integer userId, Integer certificationTypeCode, String certificationCertificatedcondition, String certificationAddress, Date createdTime) {
        this.certificationCode = certificationCode;
        this.userId = userId;
        this.certificationTypeCode = certificationTypeCode;
        this.certificationCertificatedcondition = certificationCertificatedcondition;
        this.certificationAddress = certificationAddress;
        this.createdTime = createdTime;
    }

    public Certification() {
        super();
    }

    public Integer getCertificationCode() {
        return certificationCode;
    }

    public void setCertificationCode(Integer certificationCode) {
        this.certificationCode = certificationCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCertificationTypeCode() {
        return certificationTypeCode;
    }

    public void setCertificationTypeCode(Integer certificationTypeCode) {
        this.certificationTypeCode = certificationTypeCode;
    }

    public String getCertificationCertificatedcondition() {
        return certificationCertificatedcondition;
    }

    public void setCertificationCertificatedcondition(String certificationCertificatedcondition) {
        this.certificationCertificatedcondition = certificationCertificatedcondition == null ? null : certificationCertificatedcondition.trim();
    }

    public String getCertificationAddress() {
        return certificationAddress;
    }

    public void setCertificationAddress(String certificationAddress) {
        this.certificationAddress = certificationAddress == null ? null : certificationAddress.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}