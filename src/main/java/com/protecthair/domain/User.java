package com.protecthair.domain;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPhonenumber;

    private Integer userPassword;

    private String userSexy;

    private Integer userAge;

    private String userNational;

    private String userSalt;

    private Date createdTime;

    public User(Integer userId, String userName, String userPhonenumber, Integer userPassword, String userSexy, Integer userAge, String userNational, String userSalt, Date createdTime) {
        this.userId = userId;
        this.userName = userName;
        this.userPhonenumber = userPhonenumber;
        this.userPassword = userPassword;
        this.userSexy = userSexy;
        this.userAge = userAge;
        this.userNational = userNational;
        this.userSalt = userSalt;
        this.createdTime = createdTime;
    }

    public User() {
        super();
    }

    public User(String user, String host, String selectPriv, String insertPriv, String updatePriv, String deletePriv, String createPriv, String dropPriv, String reloadPriv, String shutdownPriv, String processPriv, String filePriv, String grantPriv, String referencesPriv, String indexPriv, String alterPriv, String showDbPriv, String superPriv, String createTmpTablePriv, String lockTablesPriv, String executePriv, String replSlavePriv, String replClientPriv, String createViewPriv, String showViewPriv, String createRoutinePriv, String alterRoutinePriv, String createUserPriv, String eventPriv, String triggerPriv, String createTablespacePriv, String sslType, Integer maxQuestions, Integer maxUpdates, Integer maxConnections, Integer maxUserConnections, String plugin, String passwordExpired, Date passwordLastChanged, Short passwordLifetime, String accountLocked, String createRolePriv, String dropRolePriv, Short passwordReuseHistory, Short passwordReuseTime, String passwordRequireCurrent) {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber == null ? null : userPhonenumber.trim();
    }

    public Integer getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(Integer userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSexy() {
        return userSexy;
    }

    public void setUserSexy(String userSexy) {
        this.userSexy = userSexy == null ? null : userSexy.trim();
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserNational() {
        return userNational;
    }

    public void setUserNational(String userNational) {
        this.userNational = userNational == null ? null : userNational.trim();
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt == null ? null : userSalt.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}